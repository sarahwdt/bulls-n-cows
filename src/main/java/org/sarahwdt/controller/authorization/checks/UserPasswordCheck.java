package org.sarahwdt.controller.authorization.checks;

import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import java.util.NoSuchElementException;

public class UserPasswordCheck implements Check<User> {
    private final UserServices services;

    public UserPasswordCheck(UserServices services) {
        this.services = services;
    }

    @Override
    public String check(User target) {
        return services.findAllUsers()
                .stream()
                .filter((user)-> user.getName().equals(target.getName()))
                .findFirst()
                .orElseThrow(()->new NoSuchElementException("User with this name not found."))
                .getPassword().equals(target.getPassword())
                ? null : "Wrong password.";
    }
}
