package org.sarahwdt.controller.checker.checks.auth;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.model.entities.User;

public class NameMinLengthCheck implements Check<User> {
    private int minLength;

    public NameMinLengthCheck(int maxLength) {
        this.minLength = maxLength;
    }

    @Override
    public String check(User target) {
        return target.getName().length() >= minLength ? null : "Username can be " + minLength + " characters or more";
    }
}
