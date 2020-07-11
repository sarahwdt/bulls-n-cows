package org.sarahwdt.controller.game.core.creators;

public abstract class SecretCreator implements GameCollectionCreator {
    private final int length;

    public SecretCreator(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
