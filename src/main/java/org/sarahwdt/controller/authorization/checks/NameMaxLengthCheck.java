package org.sarahwdt.controller.authorization.checks;

import org.sarahwdt.model.entities.User;

public class NameMaxLengthCheck implements Check<User> {
    private int maxLength;

    public NameMaxLengthCheck(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String check(User target) {
        return target.getName().length() < maxLength ? null : "Username can be " + maxLength + " characters or less";
    }
}
