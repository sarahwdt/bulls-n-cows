package org.sarahwdt.controller.filter;

import org.sarahwdt.controller.authorization.SignIn;
import org.sarahwdt.controller.cookies.AuthCookieHandler;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class CookieAuthFilter implements Filter {
    FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        if (Objects.isNull(req.getSession().getAttribute("user"))) {

            Optional<User> user = AuthCookieHandler.get(req);

            user.ifPresent(user1 -> new SignIn<>(req, new UserServices()).authorize(user1));
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        config = null;
    }
}
