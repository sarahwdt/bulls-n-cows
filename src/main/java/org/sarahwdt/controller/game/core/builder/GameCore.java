package org.sarahwdt.controller.game.core.builder;

import org.sarahwdt.controller.checker.Checker;
import org.sarahwdt.controller.game.core.creators.GuessCreator;
import org.sarahwdt.controller.game.core.creators.SecretCreator;
import org.sarahwdt.controller.game.rating.Rate;
import org.sarahwdt.controller.game.score.Score;

public class GameCore {
    private SecretCreator secretCreator;
    private GuessCreator guessCreator;
    private Checker<GuessCreator> guessChecker;
    private Score score;
    private Rate rate;

    public GameCore() {
    }


    public SecretCreator getSecretCreator() {
        return secretCreator;
    }

    void setSecretCreator(SecretCreator secretCreator) {
        this.secretCreator = secretCreator;
    }

    public GuessCreator getGuessCreator() {
        return guessCreator;
    }

    void setGuessCreator(GuessCreator guessCreator) {
        this.guessCreator = guessCreator;
    }

    public Checker<GuessCreator> getGuessChecker() {
        return guessChecker;
    }

    void setGuessChecker(Checker<GuessCreator> guessChecker) {
        this.guessChecker = guessChecker;
    }

    public Score getScore() {
        return score;
    }

    void setScore(Score score) {
        this.score = score;
    }

    public Rate getRate() {
        return rate;
    }

    void setRate(Rate rate) {
        this.rate = rate;
    }
}
