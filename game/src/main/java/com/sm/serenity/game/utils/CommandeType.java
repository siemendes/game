package com.sm.serenity.game.utils;

import com.sm.serenity.game.exception.CommandeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandeType{

    HELP("H"),
    PAPER("P"),
    CHISEL("C"),
    STONE("S");

    private final String code ;

    CommandeType(String aCode) {
        this.code = aCode ;
    }

    static public String getCommandeTypeCode(CommandeType c){
        return c.code ;
    }

    static public CommandeType getCommandeTypeFromCode(String c){
        return Arrays.stream(CommandeType.values())
                .filter(e -> e.code.equals(c))
                .findFirst()
                .orElseThrow(() -> new CommandeException(String.format("Commande incorrecte : ", c)));
    }

    static public List<CommandeType> getValuesPourOrdinateur(){
        return Stream.of(CommandeType.CHISEL,CommandeType.PAPER,CommandeType.STONE).collect(Collectors.toList());
    }

    public int compareWith(CommandeType b){
            if (CommandeType.CHISEL.equals(this) && CommandeType.PAPER.equals(b)) {
                return 1;
            }
            if (CommandeType.CHISEL.equals(this) && CommandeType.STONE.equals(b)) {
                return -1;
            }
            if (CommandeType.STONE.equals(this) && CommandeType.CHISEL.equals(b)) {
                return 1;
            }
            if (CommandeType.STONE.equals(this) && CommandeType.PAPER.equals(b)) {
                return -1;
            }
            if (CommandeType.PAPER.equals(this) && CommandeType.STONE.equals(b)) {
                return 1;
            }
            if (CommandeType.PAPER.equals(this) && CommandeType.CHISEL.equals(b)) {
                return -1;
            }

            return 0;
    }
}
