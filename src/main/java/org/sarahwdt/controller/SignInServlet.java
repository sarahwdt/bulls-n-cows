package org.sarahwdt.controller;

import org.sarahwdt.model.UsersModel;
import org.sarahwdt.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");

        User user = new User(name, password);
        UsersModel model = UsersModel.getInstance();

        //TODO
        if (model.getUsers().contains(user)) {
            req.getSession().setAttribute("user", user);

            //TODO: Делать куки в отдельном классе
            Cookie nameCookie = new Cookie("name", name);
            nameCookie.setMaxAge(Integer.MAX_VALUE);
            Cookie passCookie = new Cookie("pass", password);
            passCookie.setMaxAge(Integer.MAX_VALUE);
            resp.addCookie(nameCookie);
            resp.addCookie(passCookie);

            resp.sendRedirect("/");
        } else {
            req.setAttribute("error", "Wrong name or password.");
            req.getRequestDispatcher("/pages/signin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) resp.sendRedirect("/");
        else req.getRequestDispatcher("/pages/signin.jsp").forward(req, resp);

    }
}

