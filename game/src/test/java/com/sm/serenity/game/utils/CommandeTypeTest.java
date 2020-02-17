package com.sm.serenity.game.utils;

import com.sm.serenity.game.exception.CommandeException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommandeTypeTest {

    @Test
    public void shoulRreturn_1_when_ChiselBetweenPaper(){
        Assertions.assertThat(CommandeType.CHISEL.compareWith(CommandeType.PAPER)).isEqualTo(1);
    }

    @Test
    public void shouldReturn_moins1_when_ChiselBetweenStone(){
        Assertions.assertThat(CommandeType.CHISEL.compareWith(CommandeType.STONE)).isEqualTo(-1);
    }

    @Test
    public void shouldReturn_1_when_paperBetweenStone(){
        Assertions.assertThat(CommandeType.PAPER.compareWith(CommandeType.STONE)).isEqualTo(1);
    }

    @Test(expected = CommandeException.class)
    public void shouldThrow_commandeException_when_falseCommande(){
        CommandeType.getCommandeTypeFromCode("A");
    }
}
