package org.sarahwdt.model.game;

import org.sarahwdt.model.game.core.MoveData;
import org.sarahwdt.model.game.score.Score;

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
