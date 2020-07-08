package org.sarahwdt.model.game.creators;

import org.sarahwdt.model.game.symbols.DecimalNumberSecret;
import org.sarahwdt.model.game.symbols.Symbols;

import java.util.LinkedHashSet;

public class DecimalNumberSecretCreator extends CharCollectionCreator {
    @Override
    public Symbols create() {
        LinkedHashSet<Integer> secret = new LinkedHashSet<>();
        for (int i = 0; i < this.getLength(); i++) {
            do {
                Integer rand = (int) (Math.random() * 1000 % 10);
                secret.add(rand);
            } while (secret.size() <= i);
        }
        return new DecimalNumberSecret(secret);
    }
}
