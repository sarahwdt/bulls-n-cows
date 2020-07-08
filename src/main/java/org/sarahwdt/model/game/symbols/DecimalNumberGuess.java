package org.sarahwdt.model.game.symbols;

import java.util.LinkedList;

public class DecimalNumberGuess implements Symbols {
    private final LinkedList<Integer> guess;

    public DecimalNumberGuess(LinkedList<Integer> guess) {
        this.guess = guess;
    }

    @Override
    public LinkedList<Integer> getCollection() {
        return guess;
    }
}
