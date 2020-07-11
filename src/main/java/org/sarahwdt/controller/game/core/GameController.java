package org.sarahwdt.controller.game.core;


import org.sarahwdt.controller.game.core.creators.GuessCreator;
import org.sarahwdt.model.entities.MoveData;

import java.util.List;

public interface GameController {
    boolean move(String guessString);
    List<MoveData> getDataArray();
    boolean getResult();
}