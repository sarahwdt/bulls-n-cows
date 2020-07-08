package org.sarahwdt.model.game.creators;

import org.sarahwdt.model.game.symbols.DecimalNumberGuess;
import org.sarahwdt.model.game.symbols.Symbols;

import java.util.LinkedList;

public class DecimalNumberGuessCreator extends CharCollectionCreator {
    DecimalNumberGuess guess;

    public DecimalNumberGuessCreator(String s) {
        LinkedList<Integer> guess_created = new LinkedList<>();
        if (s.length() != this.getLength()) throw new IllegalArgumentException(s);
        for (int i = 0; i < this.getLength(); i++) guess_created.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        guess = new DecimalNumberGuess(guess_created);
    }

    @Override
    public Symbols create() {
        return guess;
    }
}
