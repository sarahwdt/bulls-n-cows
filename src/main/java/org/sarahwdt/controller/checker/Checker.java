package org.sarahwdt.controller.checker;

import org.sarahwdt.controller.checker.checks.Check;

import java.util.List;

public interface Checker<T> {
    void setTarget(T target);
    T getTarget();
    void setCheckList(List<Check<T>> checkList);
    List<Check<T>> getCheckList();
    //TODO: optional
    String check();
}
