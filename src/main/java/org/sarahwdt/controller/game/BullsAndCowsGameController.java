package org.sarahwdt.controller.game;

import org.sarahwdt.controller.checker.Checker;
import org.sarahwdt.controller.game.core.GameController;
import org.sarahwdt.controller.game.core.creators.GuessCreator;
import org.sarahwdt.controller.game.core.creators.SecretCreator;
import org.sarahwdt.controller.game.core.symbols.GameCollection;
import org.sarahwdt.model.entities.Game;
import org.sarahwdt.model.entities.MoveData;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import java.util.List;

public class BullsAndCowsGameController implements GameController {
    private User user;
    private UserServices model;
    private SecretCreator secretCreator;
    private GuessCreator guessCreator;
    private Checker<String> guessChecker;

    private final GameCollection secret;

    private final Game game;

    public BullsAndCowsGameController(User user,
                                      UserServices model,
                                      SecretCreator secretCreator,
                                      GuessCreator guessCreator,
                                      Checker<String> guessChecker) {
        this.secret = creator.create();
        this.game = new Game(secret.toString(), false);
        this.user = user;
        this.model = model;
    }

    @Override
    public boolean move(String guessString) {

        GameCollection guess = guessCreator.create();

        BullsAndCowsGameMove data = new BullsAndCowsGameMove(guess,
                HeckCheck.checkBulls(secret, guess),
                HeckCheck.checkCows(secret, guess));

        game.setResult(HeckCheck.checkBulls(secret, guess) == secret.getCollection().size());
        game.addMoveData(data.getData());

        return getResult();
    }

    private void moveHandler

    public List<MoveData> getDataArray() {
        return game.getMoveData();
    }

    public Game getGame() {
        return game;
    }

    @Override
    public boolean getResult() {
        return game.isResult();
    }

}
