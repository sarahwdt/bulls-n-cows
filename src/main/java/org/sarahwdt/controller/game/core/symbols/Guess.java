package org.sarahwdt.controller.game.core.symbols;

import java.util.LinkedList;

public class Guess implements GameCollection {
    protected final LinkedList<Character> guess;

    public Guess(LinkedList<Character> guess) {
        this.guess = guess;
    }

    @Override
    public LinkedList<Character> getCollection() {
        return guess;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Character i : guess)
            result.append(i.toString());
        return result.toString();
    }
}
