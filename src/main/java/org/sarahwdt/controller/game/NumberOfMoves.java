package org.sarahwdt.controller.game;

import org.sarahwdt.controller.game.core.GameController;
import org.sarahwdt.controller.game.score.Score;

public class NumberOfMoves implements Score {
    private double score;

    public NumberOfMoves(GameController gameController) {
        this.score = gameController.getResult() ? gameController.getDataArray().size() : 0;
    }

    @Override
    public double getScore() {
        return score;
    }
}
