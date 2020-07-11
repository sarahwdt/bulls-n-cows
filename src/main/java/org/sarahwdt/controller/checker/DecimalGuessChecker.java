package org.sarahwdt.controller.checker;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.controller.game.core.creators.GuessCreator;

import java.util.List;
import java.util.Objects;

public class DecimalGuessChecker implements Checker<GuessCreator> {
    private GuessCreator target;
    private List<Check<GuessCreator>> checkList;

    public DecimalGuessChecker(GuessCreator target, List<Check<GuessCreator>> checkList) {
        this.target = target;
        this.checkList = checkList;
    }

    @Override
    public GuessCreator getTarget() {
        return target;
    }

    @Override
    public void setTarget(GuessCreator target) {
        this.target = target;
    }

    @Override
    public List<Check<GuessCreator>> getCheckList() {
        return checkList;
    }

    @Override
    public void setCheckList(List<Check<GuessCreator>> checkList) {
        this.checkList = checkList;
    }

    @Override
    public String check() {
        for (Check<GuessCreator> check : checkList)
            if (Objects.nonNull(check.check(target))) return check.check(target);
        return null;
    }
}
