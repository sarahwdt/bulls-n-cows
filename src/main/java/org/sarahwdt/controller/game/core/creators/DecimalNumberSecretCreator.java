package org.sarahwdt.controller.game.core.creators;


import org.sarahwdt.controller.game.core.symbols.GameCollection;
import org.sarahwdt.controller.game.core.symbols.Secret;

import java.util.LinkedHashSet;

public class DecimalNumberSecretCreator extends SecretCreator {
    public DecimalNumberSecretCreator(int length) {
        super(length);
    }

    @Override
    public GameCollection create() {
        LinkedHashSet<Character> secret = new LinkedHashSet<>();
        for (int i = 0; i < this.getLength(); i++) {
            do {
                int rand = (int) (Math.random() * 1000 % 10);
                secret.add(Character.forDigit(rand, 10));
            } while (secret.size() <= i);
        }
        return new Secret(secret);
    }
}
