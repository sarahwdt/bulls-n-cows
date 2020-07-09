package org.sarahwdt.controller.common;

import org.sarahwdt.model.UsersModel;
import org.sarahwdt.model.entities.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CookieAuthFilter implements Filter {
    FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getSession().getAttribute("user") == null) {
            String name = null, pass = null;
            for (Cookie c : req.getCookies()) {
                name = c.getName().equals("user")?c.getValue():null;
                pass = c.getName().equals("pass")?c.getValue():null;
            }
            if (UsersModel.getInstance().getUser(name)!=null
            && UsersModel.getInstance().getUser(name).equals( new User(name, pass)))
                req.getSession().setAttribute("user", UsersModel.getInstance().getUser(name));

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        config = null;
    }
}
