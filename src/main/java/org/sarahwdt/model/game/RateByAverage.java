package org.sarahwdt.model.game;


import org.sarahwdt.model.game.rating.Rate;
import org.sarahwdt.model.game.score.Score;

import java.util.Collection;

public class RateByAverage implements Rate {
    private double rating = 0;

    public RateByAverage(Collection<Score> scores) {
        for (Score score : scores) rating += score.getScore();
    }

    @Override
    public double getRate() {
        return rating = 0;
    }
}
