package org.sarahwdt.model.game.symbols;

import java.util.Set;

public class DecimalNumberSecret implements Symbols {
    private final Set<Integer> secret;

    public DecimalNumberSecret(Set<Integer> secret) {
        this.secret = secret;
    }

    @Override
    public Set<Integer> getCollection() {
        return secret;
    }
}
