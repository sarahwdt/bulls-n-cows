package org.sarahwdt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user")!=null){
            req.getSession().removeAttribute("user");
        }
        for(Cookie c:req.getCookies()){
            if(c.getName().equals("name")) c.setMaxAge(0);
            if(c.getName().equals("password")) c.setMaxAge(0);
        }
        resp.sendRedirect("/signin");
    }
}
