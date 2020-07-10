package org.sarahwdt.controller.checker.checks.auth;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.model.entities.User;

public class PasswordMinLengthCheck implements Check<User> {
    private int minLength;

    public PasswordMinLengthCheck(int maxLength) {
        this.minLength = maxLength;
    }

    @Override
    public String check(User target) {
        return target.getPassword().length() >= minLength ? null : "Password can be " + minLength + " characters or more";
    }
}
