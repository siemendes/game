package com.sm.serenity.game.exception;

import java.lang.RuntimeException ;

public class CommandeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur de CommandeException
     *
     * @param message
     */
    public CommandeException(String message) {
        super(message);
    }
}


