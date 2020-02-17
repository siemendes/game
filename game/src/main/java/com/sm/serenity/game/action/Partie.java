package com.sm.serenity.game.action;

import com.sm.serenity.game.model.Game;
import com.sm.serenity.game.model.ScoreTour;
import com.sm.serenity.game.service.FinPartieService;
import com.sm.serenity.game.service.InitialisationPartieService;
import com.sm.serenity.game.service.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Partie implements ApplicationRunner {

    @Autowired
    FinPartieService finPartie;

    @Autowired
    InitialisationPartieService initPartie;

    @Autowired
    PartieService partieService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{

            Game game = initPartie.initialiserPartie();
            List<ScoreTour> scores = partieService.jouerPartie(game);
            finPartie.afficherScore(scores);

        } catch(Exception e){
            System.out.println("Le lancement de la partie a echoue. Veuillez recommencer une nouvelle partie.") ;
        }
    }
}
