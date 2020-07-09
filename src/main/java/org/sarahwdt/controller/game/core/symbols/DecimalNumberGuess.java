package org.sarahwdt.controller.game.core.symbols;

import java.util.LinkedList;

public class DecimalNumberGuess implements GameCollection {
    protected final LinkedList<Integer> guess;

    public DecimalNumberGuess(LinkedList<Integer> guess) {
        this.guess = guess;
    }

    @Override
    public LinkedList<?> getCollection() {
        return guess;
    }
}
