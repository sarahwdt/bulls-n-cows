package org.sarahwdt.controller;

import org.sarahwdt.controller.authorization.Checker;
import org.sarahwdt.controller.authorization.UserChecker;
import org.sarahwdt.controller.authorization.checks.*;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");

        User user = new User(name, password);
        UserServices model = new UserServices();

        Checker<?> checker = new UserChecker(user, Arrays.asList(
                new UserNotExistCheck(model),
                new UserPasswordCheck(model)));

        if(checker.check().isEmpty()){
            model.saveUser(user);
            //TODO:Cookie and other
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("error", checker.check().get(0));
            req.getRequestDispatcher("/pages/signup.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) resp.sendRedirect("/");
        else req.getRequestDispatcher("/pages/signin.jsp").forward(req, resp);

    }
}

