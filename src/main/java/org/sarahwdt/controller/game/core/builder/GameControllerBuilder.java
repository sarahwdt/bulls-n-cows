package org.sarahwdt.controller.game.core.builder;

import org.sarahwdt.controller.game.core.GameController;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

public interface GameControllerBuilder {
    void reset();

    void setUser(User user);

    void setUserService(UserServices service);

    void setSecretCreator();

    void setGuessCreator();

    void setGuessChecker();

    void setScore();

    void setRate();

    GameController getController();
}
