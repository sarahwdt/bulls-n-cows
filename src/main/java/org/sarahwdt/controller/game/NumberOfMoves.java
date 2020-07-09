package org.sarahwdt.controller.game;

import org.sarahwdt.controller.game.core.MoveData;
import org.sarahwdt.controller.game.score.Score;

import java.util.Collection;

public class NumberOfMoves implements Score {
    private double score;

    public NumberOfMoves(Collection<MoveData> moveData) {
        for (MoveData data : moveData) this.score = data.getResult() ? moveData.size() : 0;
    }

    @Override
    public double getScore() {
        return score;
    }
}
