package org.sarahwdt.controller.checker.checks.game;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.controller.game.core.symbols.DecimalNumberGuess;

public class DecimalNumberCheck implements Check<String> {
    private String guess;

    public DecimalNumberCheck( String guess){
        this.guess = guess;
    }

    @Override
    public String check(String target) {
        try{
            Integer.parseInt(target, 10);
        } catch (NumberFormatException e){
            return "Guess must contain only numbers from 0-9";
        }
        return null;
    }
}
