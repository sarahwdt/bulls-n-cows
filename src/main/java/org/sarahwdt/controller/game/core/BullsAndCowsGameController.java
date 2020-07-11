package org.sarahwdt.controller.game.core;

import org.sarahwdt.controller.game.HeckCheck;
import org.sarahwdt.controller.game.core.builder.GameCore;
import org.sarahwdt.controller.game.core.symbols.GameCollection;
import org.sarahwdt.controller.game.core.symbols.Secret;
import org.sarahwdt.model.entities.Game;
import org.sarahwdt.model.entities.MoveData;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BullsAndCowsGameController implements GameController {
    private final GameCore gameCore = new GameCore();
    private GAME_STATE state = GAME_STATE.NOT_INIT;
    private Game game;
    private User user;
    private UserServices services;
    private Secret secret;

    private void init() {
        this.secret = (Secret) this.gameCore.getSecretCreator().create();
        this.game = new Game(this.secret.toString(), false);
        this.user.getGames().add(this.game);
        this.game.setUser(this.user);
        this.services.updateUser(this.user);
        this.state = GAME_STATE.IS_ON;
    }

    private String moveHandler() {
        GameCollection guess = this.gameCore.getGuessCreator().create();

        MoveData moveData = new MoveData(guess,
                HeckCheck.checkBulls(this.secret, guess),
                HeckCheck.checkCows(this.secret, guess));

        this.game.addMoveData(moveData);
        if (HeckCheck.checkBulls(this.secret, guess) == this.secret.getCollection().size()) {
            this.game.setResult(true);
            return winHandler();
        } else {
            this.services.updateUser(this.user);
            return null;
        }
    }

    private String winHandler() {
        this.services.updateUser(this.user);
        List<Double> scores = this.user.getGames().stream()
                .filter((Game::isResult))
                .map(game1 -> this.gameCore.getScore().getScore(game1))
                .collect(Collectors.toList());
        this.getGameCore().getRate().setRating(scores);
        this.user.setRating(this.gameCore.getRate().getRating());

        this.services.updateUser(this.user);

        this.state = GAME_STATE.FINISH;

        return "Congratulations! You won!You rate: " + user.getRating();
    }

    @Override
    public String move(String guessString) {
        if (state == GAME_STATE.NOT_INIT) init();
        if (state == GAME_STATE.FINISH) return "Game over. You won.";
        gameCore.getGuessCreator().setGuessString(guessString);
        String result = gameCore.getGuessChecker().check();
        if (Objects.nonNull(result)) return result;
        else return moveHandler();
    }

    @Override
    public Game getGame() {
        return game;
    }

    public GameCore getGameCore() {
        return gameCore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserServices getServices() {
        return services;
    }

    public void setServices(UserServices services) {
        this.services = services;
    }

    private enum GAME_STATE {
        NOT_INIT,
        IS_ON,
        FINISH
    }
}
