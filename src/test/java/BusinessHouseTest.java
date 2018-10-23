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
        when(io.getInput()).thenReturn("E,H,T");
        BusinessHouse house = new BusinessHouse(io,board);

        verify(io).display("Enter board cells with type");
        verify(board).add(CellType.EMPTY);
        verify(board).add(CellType.HOTEL);
        verify(board).add(CellType.TREASURE);
    }

    @Test
    public void businessHouseShouldAskForBoardCellsToSetTheBoardAndShouldReturnInvalidMessageForInvalidCellType() {
        when(io.getInput()).thenReturn("A");
        BusinessHouse house = new BusinessHouse(io,board);

        verify(io).display("Enter board cells with type");
        verify(io).display("Invalid cell type");
    }

    @Test
    public void setPlayersMethodShouldReturnPlayersArrayOfGivenLength() {
        when(io.getInput()).thenReturn("E,H").thenReturn("2");
        BusinessHouse house = new BusinessHouse(io,board);

        Player[] players = house.setPlayers();

        verify(io).display("Enter board cells with type");
        verify(board).add(CellType.EMPTY);
        verify(board).add(CellType.HOTEL);
        verify(io).display("Enter number of players");
        assertEquals(2,players.length);
    }

    @Test
    public void updatePlayerPostionMethodShouldInvokePlayMethodOfPlayer() {
        Player player = mock(Player.class);
        when(io.getInput()).thenReturn("E,J");
        when(board.getCellType(anyInt())).thenReturn(CellType.JAIL);
        BusinessHouse house = new BusinessHouse(io,board);
        Business business = new PayForJail(player);

        house.updatePlayerPosition(player,1);

        verify(io).display("Enter board cells with type");
        verify(board).add(CellType.EMPTY);
        verify(board).add(CellType.JAIL);
        verify(board).getPlayerPosition(player,1);
        verify(player).play(business);
    }
}