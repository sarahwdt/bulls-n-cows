package org.sarahwdt.controller.checker.checks.game;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.controller.game.core.creators.GuessCreator;

public class DecimalNumberCheck implements Check<GuessCreator> {
    @Override
    public String check(GuessCreator target) {
        try {
            Integer.parseInt(target.create().toString(), 10);
        } catch (NumberFormatException e) {
            return "Guess must contain only numbers from 0-9";
        }
        return null;
    }
}
