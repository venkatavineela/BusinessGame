import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void addMethodShouldAddTheCellTypeToTheListOfCellsOfBoard() {
        Board board = new Board();
        board.add(CellType.EMPTY);
        assertTrue(board.cells.contains(CellType.EMPTY));
    }

    @Test
    public void getCellTypeMethodShouldReturnCellTypeOfParticularIndexOfCells() {
        Board board = new Board();
        board.cells.add(CellType.EMPTY);
        board.cells.add(CellType.TREASURE);
        assertEquals(CellType.EMPTY,board.getCellType(0));
        assertEquals(CellType.TREASURE,board.getCellType(1));
    }

    @Test
    public void getPlayerPositionMethodShouldReturnPlayerPositionWithDiceOutput() {
        Board board = new Board();
        Player player = new Player();
        assertEquals(5,board.getPlayerPosition(player,5));

    }
}