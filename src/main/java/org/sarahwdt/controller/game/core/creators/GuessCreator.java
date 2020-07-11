package org.sarahwdt.controller.game.core.creators;


import org.sarahwdt.controller.game.core.symbols.GameCollection;
import org.sarahwdt.controller.game.core.symbols.Guess;

import java.util.LinkedList;

public class GuessCreator implements GameCollectionCreator {
    private String guessString;

    public String getGuessString() {
        return guessString;
    }

    public void setGuessString(String guessString) {
        this.guessString = guessString;
    }

    public GameCollection create() {
        LinkedList<Character> guess_created = new LinkedList<>();

        for (char c : getGuessString().toCharArray())
            guess_created.add(c);

        return new Guess(guess_created);
    }
}
