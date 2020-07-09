package org.sarahwdt.controller.game;


import org.sarahwdt.controller.game.core.MoveData;
import org.sarahwdt.controller.game.core.symbols.GameCollection;

public class BullsAndCowsGameData implements MoveData {
    private final GameCollection guess;
    private final int bulls;
    private final int cows;
    private final boolean result;

    public BullsAndCowsGameData(GameCollection guess, int bulls, int cows, boolean result) {
        this.guess = guess;
        this.bulls = bulls;
        this.cows = cows;
        this.result = result;
    }

    public GameCollection getGuess() {
        return guess;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public boolean getResult() {
        return result;
    }
}
