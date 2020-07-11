package org.sarahwdt.controller.checker.checks.game;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.controller.game.core.creators.GuessCreator;

public class LengthCheck implements Check<GuessCreator> {
    private final int length;

    public LengthCheck(int length) {
        this.length = length;
    }

    @Override
    public String check(GuessCreator target) {
        return target.create().toString().length() == length ? null : "Length of guess should be " + length;
    }
}
