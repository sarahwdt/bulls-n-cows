package org.sarahwdt.controller.authorization;

import org.sarahwdt.controller.authorization.checks.UserNotExistCheck;
import org.sarahwdt.controller.authorization.checks.UserPasswordCheck;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import javax.ejb.NoSuchEntityException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class SignIn<U extends User> implements Authorization<U> {
    private HttpServletRequest req;
    //TODO:model->abstract
    private UserServices model;

    public SignIn(HttpServletRequest req, UserServices model) {
        this.req = req;

        this.model = model;
    }

    public Optional<String> authorize(U userInstance) {
        Checker<?> checker = new UserChecker(userInstance, Arrays.asList(
                new UserNotExistCheck(model),
                new UserPasswordCheck(model)));
        //TODO:null->optional
        if (Objects.isNull(checker.check()))
            req.getSession().setAttribute("user", model.findUser(userInstance.getName()).
                    orElseThrow(() -> new NoSuchEntityException(userInstance.getName())));
        return Optional.ofNullable(checker.check());
    }

    public HttpServletRequest getReq() {
        return req;
    }

    public void setReq(HttpServletRequest req) {
        this.req = req;
    }

    public UserServices getModel() {
        return model;
    }

    public void setModel(UserServices model) {
        this.model = model;
    }
}
