package org.sarahwdt.controller.authorization;

import org.sarahwdt.controller.authorization.checks.Check;

import java.util.List;

public interface Checker<T> {
    void setTarget(T target);
    T getTarget();
    void setCheckList(List<Check<T>> checkList);
    List<Check<T>> getCheckList();
    List<String> check();
}
