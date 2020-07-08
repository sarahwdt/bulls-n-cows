package org.sarahwdt.model.game.symbols;

import java.util.Collection;
import java.util.LinkedList;

public class DecimalNumberGuess implements Symbols<Integer> {
    private final LinkedList<Integer> guess;
    public DecimalNumberGuess(LinkedList<Integer> guess){
        this.guess = guess;
    }
    @Override
    public Collection<Integer> getCollection() {
        return guess;
    }
}
