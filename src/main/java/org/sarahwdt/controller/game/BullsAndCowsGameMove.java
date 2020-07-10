package org.sarahwdt.controller.game;


import org.sarahwdt.controller.game.core.Move;
import org.sarahwdt.controller.game.core.symbols.GameCollection;

public class BullsAndCowsGameMove implements Move {
    private final GameCollection guess;
    private final int bulls;
    private final int cows;

    public BullsAndCowsGameMove(GameCollection guess, int bulls, int cows) {
        this.guess = guess;
        this.bulls = bulls;
        this.cows = cows;
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

    public String getData() {
        return guess.toString() + " = " + "B" + bulls + "C" + cows;
    }
}
