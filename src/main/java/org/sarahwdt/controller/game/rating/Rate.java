package org.sarahwdt.controller.game.rating;

import java.util.List;

public interface Rate {
    double getRating();

    void setRating(List<Double> scores);
}
