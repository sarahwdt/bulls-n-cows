package org.sarahwdt.controller.authorization;

import org.sarahwdt.controller.authorization.checks.Check;
import org.sarahwdt.model.entities.User;

import java.util.List;
import java.util.Objects;

public class UserChecker implements Checker<User> {
    private User target;
    private List<Check<User>> checkList;

    public UserChecker(User target, List<Check<User>> checkList){
        this.target = target;
        this.checkList = checkList;
    }

    @Override
    public void setTarget(User target) {
        this.target = target;
    }

    @Override
    public User getTarget() {
        return target;
    }

    @Override
    public void setCheckList(List<Check<User>> checkList) {
        this.checkList = checkList;
    }

    @Override
    public List<Check<User>> getCheckList() {
        return checkList;
    }

    @Override
    public String check() {
        for(Check<User> check:checkList) if (Objects.nonNull(check.check(target))) return check.check(target);
        return null;
    }
}
