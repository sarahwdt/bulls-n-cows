package org.sarahwdt.model.game;


import org.sarahwdt.model.game.symbols.Symbols;

import java.util.Iterator;

public class HeckCheck {
    public static int checkBulls(Symbols secret, Symbols userGuess) {
        if (checkCows(secret, userGuess) == 0) return 0;
        int count = 0;
        Iterator<?> c_guess = userGuess.getCollection().iterator();
        for (Object c : secret.getCollection()) if (c.equals(c_guess.next())) count++;
        return count;
    }

    public static int checkCows(Symbols secret, Symbols userGuess) {
        int count = 0;
        for (Object i : userGuess.getCollection()) {
            if (secret.getCollection().contains(i)) count++;
        }
        return count;
    }
}
