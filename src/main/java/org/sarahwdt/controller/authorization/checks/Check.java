package org.sarahwdt.controller.authorization.checks;

public interface Check<T> {
    String check(T target);
}
