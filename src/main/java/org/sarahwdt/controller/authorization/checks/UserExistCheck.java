package org.sarahwdt.controller.authorization.checks;

import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import java.util.stream.Collectors;

public class UserExistCheck implements Check<User> {
    private final UserServices services;

    public UserExistCheck(UserServices services) {
        this.services = services;
    }

    @Override
    public String check(User target) {
        return !services.findAllUsers()
                .stream()
                .map(User::getName)
                .collect(Collectors.toList())
                .contains(target.getName()) ? null : "User with name " + target.getName() + " already exists.";
    }
}
