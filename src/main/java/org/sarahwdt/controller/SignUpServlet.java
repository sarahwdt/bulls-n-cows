package org.sarahwdt.controller;

import org.sarahwdt.controller.checker.Checker;
import org.sarahwdt.controller.authorization.SignInWithCookies;
import org.sarahwdt.controller.checker.UserChecker;
import org.sarahwdt.controller.checker.checks.auth.*;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class SignUpServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        User user = new User(name, password);
        UserServices model = new UserServices();

        Checker<?> checker = new UserChecker(user, Arrays.asList(
                new NameMinLengthCheck(3),
                new NameMaxLengthCheck(32),
                new PasswordMinLengthCheck(6),
                new PasswordMaxLengthCheck(64),
                new UserExistCheck(model)));

        //TODO:null->optional
        if(Objects.isNull(checker.check())){
            model.saveUser(user);
            new SignInWithCookies<>( req, resp, model).authorize(user);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("error", checker.check());
            req.getRequestDispatcher("/pages/signup.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) resp.sendRedirect("/");
        else req.getRequestDispatcher("/pages/signup.jsp").forward(req, resp);
    }
}
