package org.sarahwdt.model.game.core;


import org.sarahwdt.model.game.core.symbols.Symbols;

import java.util.Collection;

public interface GameModel extends Iterable {
    MoveData move(Symbols guess);

    Collection<?> getResults();
}