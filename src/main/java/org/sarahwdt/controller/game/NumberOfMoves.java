package org.sarahwdt.controller.game;

import org.sarahwdt.controller.game.score.Score;
import org.sarahwdt.model.entities.Game;

public class NumberOfMoves implements Score {
    @Override
    public double getScore(Game game) {
        return game.getMoveData().size();
    }
}
