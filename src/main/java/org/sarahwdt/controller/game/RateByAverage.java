package org.sarahwdt.controller.game;


import org.sarahwdt.controller.game.rating.Rate;
import org.sarahwdt.controller.game.score.Score;

import java.util.Collection;

public class RateByAverage implements Rate {
    private double rating = 0;

    public RateByAverage(Collection<Score> scores) {
        for (Score score : scores) rating += score.getScore();
        rating/=scores.size();
    }

    @Override
    public double getRate() {
        return this.rating;
    }
}
