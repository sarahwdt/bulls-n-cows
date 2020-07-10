package org.sarahwdt.controller.checker.checks.auth;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import java.util.stream.Collectors;

public class UserNotExistCheck implements Check<User> {
    private final UserServices services;

    public UserNotExistCheck(UserServices services) {
        this.services = services;
    }

    @Override
    public String check(User target) {
        return services.findAllUsers()
                .stream()
                .map(User::getName)
                .collect(Collectors.toList())
                .contains(target.getName()) ? null : "User with name " + target.getName() +" not exists.";
    }
}
