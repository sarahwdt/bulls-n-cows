package org.sarahwdt.model.game.core.symbols;

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
}
