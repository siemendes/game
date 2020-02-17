package com.sm.serenity.game.utils;

import com.sm.serenity.game.exception.CommandeException;

import java.util.Arrays;

public enum StrategieOrdinateur {
    RANDOM("R"),
    FILE("F");

    private String code ;

    StrategieOrdinateur(String c){
        this.code = c ;
    }

    static public StrategieOrdinateur getStrategieOrdinateurFromCode(String c){
        return Arrays.stream(StrategieOrdinateur.values())
                .filter(e -> e.code.equals(c))
                .findFirst()
                .orElseThrow(() -> new CommandeException(String.format("Commande incorrecte : ", c)));
    }
}
