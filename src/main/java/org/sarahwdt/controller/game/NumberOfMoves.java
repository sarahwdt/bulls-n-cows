package org.sarahwdt.controller.game;

import org.sarahwdt.controller.game.core.GameModel;
import org.sarahwdt.controller.game.core.MoveData;
import org.sarahwdt.controller.game.score.Score;

import java.util.Collection;

public class NumberOfMoves implements Score {
    private double score;

    public NumberOfMoves(GameModel gameModel) {
        this.score = gameModel.getResult() ? gameModel.getDataArray().size() : 0;
    }

    @Override
    public double getScore() {
        return score;
    }
}
