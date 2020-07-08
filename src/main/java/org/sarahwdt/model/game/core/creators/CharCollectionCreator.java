package org.sarahwdt.model.game.core.creators;


import org.sarahwdt.model.game.core.symbols.GameCollection;

public abstract class CharCollectionCreator implements GameCollectionCreator{
    private int length = 4;

    public int getLength() {
        return length;
    }

    public CharCollectionCreator setLength(int length) {
        this.length = length;
        return this;
    }

    public abstract GameCollection create();
}
