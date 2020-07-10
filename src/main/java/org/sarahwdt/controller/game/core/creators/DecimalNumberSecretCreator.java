package org.sarahwdt.controller.game.core.creators;


import org.sarahwdt.controller.game.core.symbols.DecimalNumberSecret;
import org.sarahwdt.controller.game.core.symbols.GameCollection;

import java.util.LinkedHashSet;

public class DecimalNumberSecretCreator extends SecretCreator {
    public DecimalNumberSecretCreator(int length) {
        super(length);
    }

    @Override
    public GameCollection create() {
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