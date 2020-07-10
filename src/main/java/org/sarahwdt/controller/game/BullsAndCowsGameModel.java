package org.sarahwdt.controller.game;

import org.sarahwdt.controller.game.core.GameModel;
import org.sarahwdt.controller.game.core.MoveData;
import org.sarahwdt.controller.game.core.creators.GuessCreator;
import org.sarahwdt.controller.game.core.creators.SecretCreator;
import org.sarahwdt.controller.game.core.symbols.GameCollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BullsAndCowsGameModel implements GameModel {
    private final GameCollection secret;
    private final List<MoveData> dataArray;
    private boolean result = false;

    public BullsAndCowsGameModel(SecretCreator creator) {
        this.secret = creator.create();
        this.dataArray = new LinkedList<>();
    }

    @Override
    public BullsAndCowsGameData move(GuessCreator creator) {
        GameCollection guess = creator.create();
        if (guess.getCollection().size() != secret.getCollection().size())
            throw new IllegalArgumentException(guess.toString());

        BullsAndCowsGameData data = new BullsAndCowsGameData(guess,
                HeckCheck.checkBulls(secret, guess),
                HeckCheck.checkCows(secret, guess));

        result = HeckCheck.checkBulls(secret, guess) == secret.getCollection().size();

        dataArray.add(data);
        return data;
    }

    public List<MoveData> getDataArray() {
        return dataArray;
    }

    @Override
    public boolean getResult() {
        return result;
    }

    @Override
    public Iterator<MoveData> iterator() {
        return getDataArray().iterator();
    }
}
