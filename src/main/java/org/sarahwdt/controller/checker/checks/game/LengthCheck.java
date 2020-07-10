package org.sarahwdt.controller.checker.checks.game;

import org.sarahwdt.controller.checker.checks.Check;

public class LengthCheck implements Check<String> {
    private final int length;

    public LengthCheck(int length){
        this.length = length;
    }
    @Override
    public String check(String target) {
        return target.length()==length?null:"Length of guess should be " + length;
    }
}
