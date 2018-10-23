import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class GameTest {

    @Test
    public void startMethodShouldInvokeSetPlayersMethodFromHouseAndAskForDiceOutputAndShouldDisplayMessageForIncorrectDiceOutput() {
        InputOutput io = mock(InputOutput.class);
        BusinessHouse house = mock(BusinessHouse.class);
        Game game = new Game(io,house);
        Player[] players = new Player[2];
        when(house.setPlayers()).thenReturn(players);
        when(io.getInput()).thenReturn("20,4,5,3,7,9,4,5,8,2,6,4,7,3,7,8,11,6,12,");

        game.start();

        verify(io).display("Enter Dice output");
        verify(io).display("Enter Correct Dice output");
    }

    @Test
    public void startMethodShouldAskForDiceOutputAndShouldInvokeUpdatePlayerPositionFromBusinessHouse() {
        InputOutput io = mock(InputOutput.class);
        BusinessHouse house = mock(BusinessHouse.class);
        Game game = new Game(io,house);
        Player[] players = new Player[2];
        int i = 0;
        when(house.setPlayers()).thenReturn(players);
        when(io.getInput()).thenReturn("2,4,5,3,7,9,4,5,8,2,6,4,7,3,7,8,11,6,12,5");

        game.start();

        verify(io).display("Enter Dice output");
        verify(house).updatePlayerPosition(players[i],i);
    }
}