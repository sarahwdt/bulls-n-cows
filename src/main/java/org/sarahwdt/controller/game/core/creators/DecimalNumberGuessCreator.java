package org.sarahwdt.controller.game.core.creators;


import org.sarahwdt.controller.game.core.symbols.DecimalNumberGuess;
import org.sarahwdt.controller.game.core.symbols.GameCollection;

import java.util.LinkedList;

public class DecimalNumberGuessCreator extends GuessCreator {
    private final DecimalNumberGuess guess;


    public DecimalNumberGuessCreator(String s) {
        super(s);
        LinkedList<Integer> guess_created = new LinkedList<>();
        if (s.length() != this.getLength()) throw new IllegalArgumentException(s);
        for (int i = 0; i < this.getLength(); i++) guess_created.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        guess = new DecimalNumberGuess(guess_created);
    }

    @Override
    public GameCollection create() {
        return guess;
    }
}
