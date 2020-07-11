package org.sarahwdt.controller.game.core.symbols;

import java.util.Set;

public class Secret implements GameCollection {
    protected final Set<Character> secret;

    public Secret(Set<Character> secret) {
        this.secret = secret;
    }

    @Override
    public Set<Character> getCollection() {
        return secret;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Character i : secret)
            result.append(i.toString());
        return result.toString();
    }
}
