package org.sarahwdt.model.game;

import org.sarahwdt.model.game.core.GameModel;
import org.sarahwdt.model.game.core.creators.DecimalNumberSecretCreator;
import org.sarahwdt.model.game.core.symbols.Symbols;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class BullsAndCowsGameModel implements GameModel {
    private final Symbols secret;
    private final LinkedList<BullsAndCowsGameData> results;

    public BullsAndCowsGameModel(int secretLength) {
        secret = new DecimalNumberSecretCreator().setLength(secretLength).create();
        this.results = new LinkedList<>();
    }

    @Override
    public BullsAndCowsGameData move(Symbols guess) {
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
