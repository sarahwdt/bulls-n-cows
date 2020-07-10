package org.sarahwdt.controller.game.core.symbols;

import java.util.Set;

public class DecimalNumberSecret implements GameCollection {
    protected final Set<Integer> secret;

    public DecimalNumberSecret(Set<Integer> secret) {
        this.secret = secret;
    }

    @Override
    public Set<?> getCollection() {
        return secret;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Integer i:secret)
            result.append(i.toString());
        return result.toString();
    }
}
