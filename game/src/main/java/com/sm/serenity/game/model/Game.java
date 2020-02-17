package com.sm.serenity.game.model;

import com.sm.serenity.game.utils.StrategieOrdinateur;

public class Game {

    private int nbParties ;
    private StrategieOrdinateur strategie ;

    public Game() {}

    public int getNbParties() {
        return nbParties;
    }

    public void setNbParties(int nbParties) {
        this.nbParties = nbParties;
    }

    public StrategieOrdinateur getStrategie() {
        return strategie;
    }

    public void setStrategie(StrategieOrdinateur strategie) {
        this.strategie = strategie;
    }

}
