package org.sarahwdt.controller.checker;

import org.sarahwdt.controller.checker.checks.Check;
import org.sarahwdt.controller.checker.checks.game.DecimalNumberCheck;
import org.sarahwdt.model.entities.User;

import java.util.List;
import java.util.Objects;

public class DecimalGuessChecker implements Checker<String>{
    private String target;
    List<Check<String>> checkList;

    public DecimalGuessChecker(String target, List<Check<String>> checkList){
        this.target = target;
        this.checkList = checkList;
    }

    @Override
    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public void setCheckList(List<Check<String>> checkList) {
        this.checkList = checkList;
    }

    @Override
    public List<Check<String>> getCheckList() {
        return checkList;
    }

    @Override
    public String check() {
        for(Check<String> check:checkList) if (Objects.nonNull(check.check(target))) return check.check(target);
        return null;
    }
}
