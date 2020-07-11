package org.sarahwdt.controller.checker;

import org.sarahwdt.controller.checker.checks.Check;

import java.util.List;

public interface Checker<T> {
    T getTarget();

    void setTarget(T target);

    List<Check<T>> getCheckList();

    void setCheckList(List<Check<T>> checkList);

    //TODO: optional
    String check();
}
