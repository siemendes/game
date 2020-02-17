package com.sm.serenity.game.service;

import com.sm.serenity.game.exception.CommandeException;
import com.sm.serenity.game.model.DemandeChoixOrdinateur;
import com.sm.serenity.game.model.Game;
import com.sm.serenity.game.model.ScoreTour;
import com.sm.serenity.game.utils.CommandeType;
import com.sm.serenity.game.utils.StrategieOrdinateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("partieService")
public class PartieService {

    @Autowired
    FileService fileService ;

    @Autowired
    CommandLineReaderService commandLineReaderService;

    protected CommandeType getCommendeFromFileByPosition(List<CommandeType> commandes, int position){
        return commandes.get(position);
    }

    protected CommandeType getRandomCommandeType(){
        Random random = new Random();
        return CommandeType.getValuesPourOrdinateur().get(random.nextInt(CommandeType.getValuesPourOrdinateur().size()));
    }

    public List<ScoreTour> jouerPartie(Game game) throws IOException {
        List<ScoreTour> scores = new ArrayList<>();

        do{
            System.out.println("Veuillez faire votre choix entre P pour Paper, S pour Stone, C pour Chisel.");
            ScoreTour score ;
            CommandeType commandeOrdinateur ;
            if(StrategieOrdinateur.FILE.equals(game.getStrategie())) {
                List<CommandeType> commandesFromFile = fileService.getCommandesFromFile();
                commandeOrdinateur = getChoixOrdinateur(() -> getCommendeFromFileByPosition(commandesFromFile, scores.size()));
            }else {
                commandeOrdinateur = getChoixOrdinateur(() -> getRandomCommandeType());
            }
            score = jouer(commandeOrdinateur);
            if(score != null){
                scores.add(score);
            }
        }while(scores.size() < game.getNbParties());

        return scores;
    }

    protected ScoreTour jouer(CommandeType choixOrdinateur) throws IOException {

        ScoreTour unScore = null;
        boolean isChoixJoueurValide = false ;

        do{
            try {

                    CommandeType choixJoueur = this.getChoixJoueur();
                    isChoixJoueurValide = true;

                    if (CommandeType.HELP.equals(choixJoueur)) {
                        this.aider();
                    } else {

                        System.out.println("L'ordinateur a choisi " + choixOrdinateur.toString());

                        unScore = new ScoreTour();
                        unScore.enregistrementScoreJoueur(choixJoueur.compareWith(choixOrdinateur));
                        this.afficheScoreTour(unScore);
                    }
            } catch (CommandeException e) {
                    System.out.print(e.getMessage()
                            + "Pour obtenir de l'aide, taper : \n" +
                            "	H\n");
            }
        }while(!isChoixJoueurValide);


        return unScore;
    }

    protected CommandeType getChoixJoueur() throws IOException {

        String commande = commandLineReaderService.getCommandeLine();
        CommandeType choixJoueur = CommandeType.getCommandeTypeFromCode(commande);
        System.out.println("Vous avez choisi " + choixJoueur.toString());
        return choixJoueur;
    }

    protected CommandeType getChoixOrdinateur(DemandeChoixOrdinateur c) {
        return c.joue();
    }

    protected void afficheScoreTour(ScoreTour unScore){
        if (unScore.isJoueurGagnant()) {
            System.out.println("Vous avez gagne ce tour !");
        } else if(unScore.isOrdinateurGagnant()){
            System.out.println("Vous avez perdu ce tour !");
        }else{
            System.out.println("Tour nul !");
        }
    }

    protected void aider() {
        System.out.print("COMMANDES DU PROGRAMME\n" +
                "Jeu Serenity, commandes possibles :\n" +
                "Au commencement de la partie, on vous demandera de definir un nombre de parties a jouer. Vous devrez saisir un entier entre 1 et 5.\n" +
                "Au commencement de la partie, on vous demandera de choisir la stratagie de jeu de l'ordinateur, taper la commande correspondant a votre action parmis les commandes suivantes :\n" +
                "	R pour un choix aleatoire du coup a jouer\n" +
                "	F pour un choix issu d'un fichier de configuration\n" +
                "Pour jouer un coup, taper la commande correspondant a votre action parmis les commandes suivantes :\n" +
                "	S pour Stone\n" +
                "	C pour Chisel\n" +
                "	P pour Paper\n\n" +
                "Pour obtenir de l'aide, taper : \n" +
                "	H\n");
    }
}
