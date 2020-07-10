package org.sarahwdt.controller.checker.checks.auth;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.model.entities.User;

public class PasswordMaxLengthCheck implements Check<User> {
    private int maxLength;

    public PasswordMaxLengthCheck(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String check(User target) {
        return target.getPassword().length() < maxLength ? null : "Password can be " + maxLength + " characters or less";
    }
}
