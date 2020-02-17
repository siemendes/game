package com.sm.serenity.game.service;

import com.sm.serenity.game.model.ScoreTour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("finPartie")
public class FinPartieService {

    public void afficherScore(List<ScoreTour> scores ){

        Long nbPartiesGagneesJoueur = scores.stream().filter(x->x.isJoueurGagnant() == true).count();
        Long nbPartiesGagneesOrdinateur = scores.stream().filter(x->x.isOrdinateurGagnant() == true).count();

        System.out.print("Vous avez gagne " + nbPartiesGagneesJoueur.toString() + " parties "
         + "contre " + nbPartiesGagneesOrdinateur +" parties gagnees par l'ordinateur.");

        if( nbPartiesGagneesJoueur > nbPartiesGagneesOrdinateur ){
            System.out.print(" Bravo, vous avez gagne la partie !");
        }else if ( nbPartiesGagneesJoueur < nbPartiesGagneesOrdinateur ){
            System.out.print(" Desolee, cette fois c'est vous qui avez perdu !");
        }else {
            System.out.print(" EGALITE !");
        }
    }
}
