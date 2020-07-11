package org.sarahwdt.controller;

import org.sarahwdt.controller.misc.UsersDataWrapper;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;


public class RatingServlet extends HttpServlet {

    public RatingServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserServices services = new UserServices();
        UsersDataWrapper users = new UsersDataWrapper(services.findAllUsers()
                .stream()
                .filter(user -> user.getRating() > 0)
                .sorted((Comparator.comparingDouble(User::getRating)))
                .collect(Collectors.toList()));
        req.setAttribute("users_array", users);

        req.getRequestDispatcher("/pages/rating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
