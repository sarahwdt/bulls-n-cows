package org.sarahwdt.model.game.creators;


import org.sarahwdt.model.game.symbols.Symbols;

public abstract class CharCollectionCreator {
    private int length = 4;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public abstract Symbols create();
}
