package org.sarahwdt.model.entities;

import org.sarahwdt.controller.game.core.symbols.GameCollection;

import javax.persistence.*;

@Entity
@Table(name = "movedata")
public class MoveData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "guess")
    private String guess;
    @Column (name = "bulls")
    private int bulls;
    @Column (name = "cows")
    private int cows;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    public MoveData(){

    }

    public MoveData(GameCollection guess, int bulls, int cows){
        this.guess = guess.toString();
        this.bulls = bulls;
        this.cows = cows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return guess + " = " + "B" + bulls + "C" + cows;
    }
}
