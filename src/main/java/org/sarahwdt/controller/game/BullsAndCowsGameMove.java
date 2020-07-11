package org.sarahwdt.controller.game;


import org.sarahwdt.controller.game.core.Move;
import org.sarahwdt.controller.game.core.symbols.GameCollection;
import org.sarahwdt.model.entities.MoveData;

public class BullsAndCowsGameMove implements Move {
    private final MoveData data;

    public BullsAndCowsGameMove(GameCollection guess, int bulls, int cows) {
        data = new MoveData(guess, bulls, cows);
    }

    public MoveData getData() {
        return data;
    }
}
