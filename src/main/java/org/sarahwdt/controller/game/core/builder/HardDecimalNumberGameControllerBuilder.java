package org.sarahwdt.controller.game.core.builder;


import org.sarahwdt.controller.checker.DecimalGuessChecker;
import org.sarahwdt.controller.checker.checks.game.DecimalNumberCheck;
import org.sarahwdt.controller.checker.checks.game.LengthCheck;
import org.sarahwdt.controller.game.NumberOfMoves;
import org.sarahwdt.controller.game.RateByAverage;
import org.sarahwdt.controller.game.core.BullsAndCowsGameController;
import org.sarahwdt.controller.game.core.GameController;
import org.sarahwdt.controller.game.core.creators.DecimalNumberSecretCreator;
import org.sarahwdt.controller.game.core.creators.GuessCreator;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import java.util.Arrays;

public class HardDecimalNumberGameControllerBuilder implements GameControllerBuilder {
    private BullsAndCowsGameController controller;

    @Override
    public void reset() {
        this.controller = new BullsAndCowsGameController();
    }

    @Override
    public void setUser(User user) {
        controller.setUser(user);
    }

    @Override
    public void setUserService(UserServices service) {
        controller.setServices(service);
    }

    @Override
    public void setSecretCreator() {
        controller.getGameCore().setSecretCreator(new DecimalNumberSecretCreator(9));
    }

    @Override
    public void setGuessCreator() {
        controller.getGameCore().setGuessCreator(new GuessCreator());
    }

    @Override
    public void setGuessChecker() {
        controller.getGameCore().setGuessChecker(new DecimalGuessChecker(controller.getGameCore().getGuessCreator(), Arrays.asList(
                new LengthCheck(9),
                new DecimalNumberCheck()
        )));

    }

    @Override
    public void setScore() {
        controller.getGameCore().setScore(new NumberOfMoves());
    }

    @Override
    public void setRate() {
        controller.getGameCore().setRate(new RateByAverage());
    }

    @Override
    public GameController getController() {
        return controller;
    }

}
