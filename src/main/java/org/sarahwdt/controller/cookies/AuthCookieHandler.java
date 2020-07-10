package org.sarahwdt.controller.cookies;

import org.sarahwdt.model.entities.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

public class AuthCookieHandler{
    public static void set(User user, HttpServletResponse response) {
        response.addCookie(new Cookie("name", user.getName()));
        response.addCookie(new Cookie("pass", user.getPassword()));
    }

    public static Optional<User> get(HttpServletRequest request) {
        Optional<Cookie> name = Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals("name"))
                .findFirst();
        Optional<Cookie> password = Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals("pass"))
                .findFirst();
        return name.isPresent() && password.isPresent()?
                Optional.of(new User(name.get().getValue(), password.get().getValue())):
                Optional.empty();
    }


    public static void delete(HttpServletResponse response) {
        Cookie name = new Cookie("name", ""), pass = new Cookie("pass", "");

        name.setMaxAge(0);
        pass.setMaxAge(0);

        response.addCookie(name);
        response.addCookie(pass);
    }
}
