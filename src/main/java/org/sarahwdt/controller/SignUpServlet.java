package org.sarahwdt.controller;

import org.sarahwdt.model.UsersModel;
import org.sarahwdt.model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("pass");

        UsersModel model = UsersModel.getInstance();
        //TODO: говна какая то
        if (!model.list().contains(name)) {

            User user = new User(name, password);
            model.add(user);

            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/");

        } else {
            req.setAttribute("error", "User with name " + name + " already exist.");
            req.getRequestDispatcher("/pages/signup.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) resp.sendRedirect("/");
        else req.getRequestDispatcher("/pages/signup.jsp").forward(req, resp);
    }
}
