import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BusinessHouseTest {

    InputOutput io = mock(InputOutput.class);
    Board board = mock(Board.class);

    @Test
    public void businessHouseShouldAskForBoardCellsToSetTheBoardAndShouldInvokeAddMethodFromBoardForValidCellTypes() {
        when(io.getInput()).thenReturn("H,J");
        Cell hotel = new Hotel();
        Cell jail = new Jail();
        BusinessHouse house = new BusinessHouse(io,board);

        verify(io).display("Enter board cells with type");
        verify(board).add(hotel);
        verify(board).add(jail);
    }

    @Test
    public void setPlayersMethodShouldReturnPlayersArrayOfGivenLength() {
        when(io.getInput()).thenReturn("T,H,J").thenReturn("2");
        BusinessHouse house = new BusinessHouse(io,board);
        Cell hotel = new Hotel();
        Cell jail = new Jail();
        Cell treasure = new Treasure();
        Player[] players = house.setPlayers();

        verify(io).display("Enter board cells with type");
        verify(board).add(treasure);
        verify(board).add(hotel);
        verify(board).add(jail);

        verify(io).display("Enter number of players");
        assertEquals(2,players.length);
    }

    @Test
    public void updatePlayerPostionMethodShouldInvokePlayMethodOfPlayer() {
        Player player = mock(Player.class);
        when(io.getInput()).thenReturn("T,J,H");
        BusinessHouse house = new BusinessHouse(io,board);
        Cell hotel = new Hotel();
        Cell jail = new Jail();
        Cell treasure = new Treasure();
        when(board.getCell(anyInt())).thenReturn(jail);


        house.updatePlayerPosition(player,1);

        verify(io).display("Enter board cells with type");
        verify(board).add(treasure);
        verify(board).add(jail);
        verify(board).add(hotel);


        verify(board).getPlayerPosition(player,1);
        verify(player).play(jail);
    }
}