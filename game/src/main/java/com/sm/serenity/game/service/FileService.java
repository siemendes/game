package com.sm.serenity.game.service;

import com.sm.serenity.game.utils.CommandeType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service("fileService")
public class FileService {

    @Value("#{'${listChoixOrdinateur}'.split(',')}")
    protected List<String> choixOrdinateurFromFile;

    public List<CommandeType> getCommandesFromFile() throws IOException {
        List<CommandeType> commandes = choixOrdinateurFromFile.stream().map(x-> CommandeType.getCommandeTypeFromCode(x)).collect(Collectors.toList());
        return commandes ;
    }
}
