package com.sm.serenity.game.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service("commandLineReaderService")
public class CommandLineReaderService {

    public String getCommandeLine() throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader entree = new BufferedReader(in);
        if(entree ==null || !entree.ready()){
            entree=new BufferedReader(in);
        }
        return entree.readLine();
    }
}
