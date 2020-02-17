package com.sm.serenity.game.exception;

import java.lang.RuntimeException ;

public class LectureException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur LectureException
     * @param message
     *
     */
    public LectureException(String message){
        System.out.println(this.getClass() + " : "+message);
    }

}