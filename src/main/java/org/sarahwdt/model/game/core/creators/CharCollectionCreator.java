package org.sarahwdt.model.game.core.creators;


import org.sarahwdt.model.game.core.symbols.Symbols;

public abstract class CharCollectionCreator {
    private int length = 4;

    public int getLength() {
        return length;
    }

    public CharCollectionCreator setLength(int length) {
        this.length = length;
        return this;
    }

    public abstract Symbols create();
}
