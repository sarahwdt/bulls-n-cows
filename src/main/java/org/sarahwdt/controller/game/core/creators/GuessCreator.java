package org.sarahwdt.controller.game.core.creators;


public abstract class GuessCreator extends CharCollectionCreator{
    public GuessCreator(String s) {
        if(s.length()!=getLength()) throw new IllegalArgumentException(s);
    }
}
