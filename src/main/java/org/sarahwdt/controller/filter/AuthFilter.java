package org.sarahwdt.controller.filter;

import org.sarahwdt.model.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        User user = (User) req.getSession().getAttribute("user");
        if(user == null) resp.sendRedirect("/signin");
        else filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        this.config = null;
    }
}
