import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    @Test
    public void gameSetUpShouldAskForNumberOfPlayersAndBoardCellsAndDiceOutput() {
        InputOutput io = mock(InputOutput.class);
        when(io.getInput()).thenReturn("2").thenReturn("E,H,T,E,E,J,E,T,H").thenReturn("2,4,5,3,7,9,4,5,8,2,6,4,7,3,7,8,11,6,12,5");
        Game game = new Game(io);
         verify(io).display("Enter number of players");
         verify(io).display("Enter board cells with type");
         verify(io).display("Enter Dice output");
    }

    @Test
    public void gameSetUpShouldReturnInvalidCellTypeMessageWhenValidCellTypeIsNotGiven() {
        InputOutput io = mock(InputOutput.class);
        when(io.getInput()).thenReturn("2").thenReturn("E,H,T,E,E,J,E,T,H,A").thenReturn("2,4,5,3,7,9,4,5,8,2,6,4,7,3,7,8,11,6,12,5");
        Game game = new Game(io);
        verify(io).display("Enter number of players");
        verify(io).display("Enter board cells with type");
        verify(io).display("Invalid cell type");
    }

    @Test
    public void gameSetUpShouldReturnInvalidDiceOutputWhenValidOutputIsNotGiven() {
        InputOutput io = mock(InputOutput.class);
        when(io.getInput()).thenReturn("2").thenReturn("E,H,T,E,E,J,E,T,H").thenReturn("2,4,5,3,7,9,4,5,8,2,6,4,7,3,7,8,11,6,12,13");
        Game game = new Game(io);
        verify(io).display("Enter number of players");
        verify(io).display("Enter board cells with type");
        verify(io).display("Enter Dice output");
        verify(io).display("Invalid dice output");
    }
}