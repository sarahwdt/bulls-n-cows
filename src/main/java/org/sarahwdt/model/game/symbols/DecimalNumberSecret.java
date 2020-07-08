package org.sarahwdt.model.game.symbols;

import java.util.Collection;
import java.util.LinkedHashSet;

public class DecimalNumberSecret implements Symbols<Integer> {
    private final LinkedHashSet<Integer> secret;
    public DecimalNumberSecret(LinkedHashSet<Integer> secret){
        this.secret = secret;
    }
    @Override
    public Collection<Integer> getCollection() {
        return secret;
    }
}
