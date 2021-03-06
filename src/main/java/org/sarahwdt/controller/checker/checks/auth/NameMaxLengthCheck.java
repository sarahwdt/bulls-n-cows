package org.sarahwdt.controller.checker.checks.auth;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.model.entities.User;

public class NameMaxLengthCheck implements Check<User> {
    private final int maxLength;

    public NameMaxLengthCheck(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String check(User target) {
        return target.getName().length() < maxLength ? null : "Username can be " + maxLength + " characters or less";
    }
}
