package org.sarahwdt.controller.authorization;

import org.sarahwdt.controller.cookies.AuthCookieHandler;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class SignInWithCookies<U extends User> extends SignIn<U>{
    private HttpServletResponse resp;

    public SignInWithCookies(HttpServletRequest req, HttpServletResponse resp, UserServices model) {
        super(req, model);
        this.resp = resp;
    }

    public Optional<String> authorize(U userInstance) {
        Optional<String> result = super.authorize(userInstance);

        if (!result.isPresent()) AuthCookieHandler.set(userInstance, getResp());
        return result;
    }

    public HttpServletResponse getResp() {
        return resp;
    }

    public void setResp(HttpServletResponse resp) {
        this.resp = resp;
    }
}
