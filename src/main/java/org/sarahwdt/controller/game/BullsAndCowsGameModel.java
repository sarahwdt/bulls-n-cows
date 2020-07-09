package org.sarahwdt.controller.game;

import org.sarahwdt.controller.game.core.GameModel;
import org.sarahwdt.controller.game.core.creators.GuessCreator;
import org.sarahwdt.controller.game.core.creators.SecretCreator;
import org.sarahwdt.controller.game.core.symbols.GameCollection;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class BullsAndCowsGameModel implements GameModel {
    private final GameCollection secret;
    private final LinkedList<BullsAndCowsGameData> results;

    public BullsAndCowsGameModel(SecretCreator creator) {
        secret = creator.create();
        this.results = new LinkedList<>();
    }

    @Override
    public BullsAndCowsGameData move(GuessCreator creator) {
        GameCollection guess = creator.create();
        if (guess.getCollection().size() != secret.getCollection().size())
            throw new IllegalArgumentException(guess.toString());

        BullsAndCowsGameData result = new BullsAndCowsGameData(guess,
                HeckCheck.checkBulls(secret, guess),
                HeckCheck.checkCows(secret, guess),
                HeckCheck.checkBulls(secret, guess) == secret.getCollection().size());
        results.add(result);
        return result;
    }

    @Override
    public Collection<BullsAndCowsGameData> getResults() {
        return results;
    }

    @Override
    public Iterator<BullsAndCowsGameData> iterator() {
        return getResults().iterator();
    }
}
