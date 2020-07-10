package org.sarahwdt.controller.checker.checks;

public interface Check<T> {
    String check(T target);
}
