package org.sarahwdt.controller.game.core.builder;

import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

public class GameDirector {
    private GameControllerBuilder builder;
    private final User user;
    private final UserServices services;

    public GameDirector(GameControllerBuilder builder, User user, UserServices services) {
        this.builder = builder;
        this.user = user;
        this.services = services;
    }

    public void changeBuilder(GameControllerBuilder builder) {
        this.builder = builder;
    }

    public void makeController() {
        builder.reset();
        builder.setUser(user);
        builder.setUserService(services);
        builder.setSecretCreator();
        builder.setGuessCreator();
        builder.setGuessChecker();
        builder.setRate();
        builder.setScore();
    }
}
