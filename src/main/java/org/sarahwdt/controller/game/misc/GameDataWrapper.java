package org.sarahwdt.controller.game.misc;

import org.sarahwdt.controller.game.core.MoveData;

import java.util.Collection;
import java.util.List;

public class GameDataWrapper {
    public Collection<MoveData> collection;

    public GameDataWrapper(Collection<MoveData> collection) {
        this.collection = collection;
    }

    public void setCollection(Collection<MoveData> collection) {
        this.collection = collection;
    }

    public Collection<MoveData> getCollection() {
        return collection;
    }
}
