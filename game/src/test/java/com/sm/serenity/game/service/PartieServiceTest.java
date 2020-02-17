package com.sm.serenity.game.service;

import com.sm.serenity.game.model.Game;
import com.sm.serenity.game.model.ScoreTour;
import com.sm.serenity.game.utils.CommandeType;
import com.sm.serenity.game.utils.StrategieOrdinateur;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class PartieServiceTest {


    @InjectMocks
    private PartieService partieService = new PartieService();

    @Mock
    private CommandLineReaderService commandLineReaderService ;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturn_ComputerWinner_when_computerPlayChisel_and_gamerPlayPaper() throws IOException, URISyntaxException {
        Mockito.when(commandLineReaderService.getCommandeLine()).thenReturn("P");
        ScoreTour score = partieService.jouer(CommandeType.CHISEL);
        Assertions.assertThat(score.isOrdinateurGagnant()).isEqualTo(true) ;
    }

    @Test
    public void shouldScores_final_contains_2_elements_when_2Rounds_game() throws IOException, URISyntaxException {

        Mockito.when(commandLineReaderService.getCommandeLine()).thenReturn("P");

        Game game = Mockito.mock(Game.class);
        Mockito.when(game.getStrategie()).thenReturn(StrategieOrdinateur.RANDOM);
        Mockito.when(game.getNbParties()).thenReturn(2);

        List<ScoreTour> scores = partieService.jouerPartie(game);
        Assertions.assertThat(scores.size()).isEqualTo(2) ;
    }
}
