package org.sarahwdt.controller.game.core;


import org.sarahwdt.controller.game.core.creators.GuessCreator;

import java.util.List;

public interface GameModel extends Iterable<Move> {
    Move move(GuessCreator creator);
    List<Move> getDataArray();
    boolean getResult();
}