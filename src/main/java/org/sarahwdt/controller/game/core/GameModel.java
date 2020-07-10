package org.sarahwdt.controller.game.core;


import org.sarahwdt.controller.game.core.creators.GuessCreator;

import java.util.List;

public interface GameModel extends Iterable<MoveData> {
    MoveData move(GuessCreator creator);
    List<MoveData> getDataArray();
    boolean getResult();
}