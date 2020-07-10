package org.sarahwdt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!Objects.isNull(req.getSession().getAttribute("user"))) req.getSession().removeAttribute("user");

        Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals("name") || cookie.getName().equals("password"))
                .forEach(cookie -> cookie.setMaxAge(0));

        resp.sendRedirect("/");
    }
}
