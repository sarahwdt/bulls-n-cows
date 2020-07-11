package org.sarahwdt.controller.game;


import org.sarahwdt.controller.game.rating.Rate;

import java.util.List;

public class RateByAverage implements Rate {
    private double rating = 0;

    @Override
    public double getRating() {
        return this.rating;
    }

    @Override
    public void setRating(List<Double> scores) {
        for (Double score : scores) rating += score;
        rating /= scores.size();
    }
}
