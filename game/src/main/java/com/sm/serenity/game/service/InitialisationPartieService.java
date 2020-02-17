package com.sm.serenity.game.service;

import com.sm.serenity.game.exception.CommandeException;
import com.sm.serenity.game.model.Game;
import com.sm.serenity.game.utils.StrategieOrdinateur;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service("initPartie")
public class InitialisationPartieService {

    public Game initialiserPartie() {
        Game game = new Game();

        game.setStrategie(getStrategieOrdinateurFromJoueur());
        game.setNbParties(getNbPartiesFromJoueur());

        return game ;
    }

    private int getNbPartiesFromJoueur(){
        boolean isSaisieNbPartiesOK = false ;
        System.out.print("Veuillez choisir le nombre de parties a jouer.\n"
                + "Vous devez saisir un entier entre 1 et 5.\n");

        Integer nbParties = 0 ;
        while(!isSaisieNbPartiesOK){
            try{
                BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
                String value = entree.readLine();
                nbParties = Integer.decode(value);
                if(nbParties < 1 || nbParties > 5){
                    throw new CommandeException("Votre choix doit etre compris entre 1 et 5\n") ;
                }

                isSaisieNbPartiesOK = true ;

            }catch(CommandeException e){
                System.out.print(e.getMessage());
            }catch(NumberFormatException e){
                System.out.print("Votre reponse ne correspond pas au format souhaite.\n"
                        +"Vous devez saisir un entier.\n");
            }catch(IOException e){
                System.out.print("Suite a une erreur du systeme, nous n'avons pas pu interpreter votre saisie.\n"
                        +"Veuillez re saisir votre choix.\n");
            }
        }
        return nbParties.intValue();
    }


    private StrategieOrdinateur getStrategieOrdinateurFromJoueur(){
        boolean isSaisieStrategieOK = false ;

        System.out.print("Veuillez choisir la strategie de l'ordinateur : \n"
                + "	R pour un choix aleatoire du coup à jouer\n"
                + "	F pour un choix issu d'un fichier de configuration\n");

        StrategieOrdinateur strategieOrdinateur = null ;
        while(!isSaisieStrategieOK){
            try{
                BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
                strategieOrdinateur = StrategieOrdinateur.getStrategieOrdinateurFromCode(entree.readLine());
                isSaisieStrategieOK = true ;

            }catch(CommandeException e){
                System.out.print("Saisie incorrecte, vous devez saisir l'une des 2 valeurs : \n"
                        + "	R pour un choix aleatoire du coup a jouer\n"
                        + "	F pour un choix issu d'un fichier de configuration\n" );
            }catch(IOException e){
                System.out.print("Suite a une erreur du systeme, nous n'avons pas pu interpreter votre saisie.\n"
                        +"Veuillez re saisir votre choix.\n");
            }
        }

        return strategieOrdinateur;
    }

}
