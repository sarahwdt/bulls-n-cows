package org.sarahwdt.model.game.core;


import org.sarahwdt.model.game.core.creators.GuessCreator;
import org.sarahwdt.model.game.core.symbols.GameCollection;

import java.util.Collection;

public interface GameModel extends Iterable {
    MoveData move(GuessCreator creator);
    Collection<?> getResults();
}