package com.sm.serenity.game.model;

public class ScoreTour {

    private boolean isJoueurGagnant ;
    private boolean isOrdinateurGagnant;

    public ScoreTour() {
        this.isJoueurGagnant = false;
        this.isOrdinateurGagnant = false ;
    }

    public boolean isJoueurGagnant() {
        return this.isJoueurGagnant;
    }

    public boolean isOrdinateurGagnant() {
        return this.isOrdinateurGagnant;
    }

    public void enregistrementScoreJoueur(int nbPointsJoueur){
        if(nbPointsJoueur > 0 ){
            this.isJoueurGagnant = true ;
        }
        if(nbPointsJoueur < 0 ){
            this.isOrdinateurGagnant = true ;
        }
    }
}
