package org.sarahwdt.controller;

import org.sarahwdt.controller.authorization.SignInWithCookies;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");

        User user = new User(name, password);
        UserServices model = new UserServices();

        SignInWithCookies<User> signIn = new SignInWithCookies<>(req, resp, model);
        Optional<String> authResult = signIn.authorize(user);

        if (!authResult.isPresent()) {
            resp.sendRedirect("/");
        } else {
            req.setAttribute("error", authResult.get());
            req.getRequestDispatcher("/pages/signup.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) resp.sendRedirect("/");
        else req.getRequestDispatcher("/pages/signin.jsp").forward(req, resp);

    }
}

