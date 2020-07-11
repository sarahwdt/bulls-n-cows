package org.sarahwdt.controller.game.core;


import org.sarahwdt.controller.game.core.builder.GameCore;
import org.sarahwdt.model.entities.Game;

public interface GameController {
    String move(String guessString);

    Game getGame();

    GameCore getGameCore();
}