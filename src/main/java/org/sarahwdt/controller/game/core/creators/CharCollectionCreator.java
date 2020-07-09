package org.sarahwdt.controller.game.core.creators;


import org.sarahwdt.controller.game.core.symbols.GameCollection;

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
