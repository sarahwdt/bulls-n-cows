package org.sarahwdt.controller.game.core;


import org.sarahwdt.controller.game.core.creators.GuessCreator;

import java.util.Collection;

public interface GameModel extends Iterable {
    MoveData move(GuessCreator creator);
    Collection<?> getResults();
}