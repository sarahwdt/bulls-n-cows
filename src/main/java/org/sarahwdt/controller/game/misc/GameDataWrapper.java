package org.sarahwdt.controller.game.misc;

import org.sarahwdt.controller.game.core.Move;

import java.util.Collection;

public class GameDataWrapper {
    public Collection<Move> collection;

    public GameDataWrapper(Collection<Move> collection) {
        this.collection = collection;
    }

    public void setCollection(Collection<Move> collection) {
        this.collection = collection;
    }

    public Collection<Move> getCollection() {
        return collection;
    }
}
