package org.sarahwdt.controller;

import org.sarahwdt.controller.cookies.AuthCookieHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (Objects.nonNull(req.getSession().getAttribute("user"))) req.getSession().removeAttribute("user");

        AuthCookieHandler.delete(resp);

        resp.sendRedirect("/");
    }
}
