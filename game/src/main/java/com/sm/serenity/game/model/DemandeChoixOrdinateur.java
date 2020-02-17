package com.sm.serenity.game.model;

import com.sm.serenity.game.utils.CommandeType;

@FunctionalInterface
public interface DemandeChoixOrdinateur {
    CommandeType joue();
}
