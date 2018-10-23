import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void addMethodShouldAddTheCellTypeToTheListOfCellsOfBoard() {
        Board board = new Board();
        Cell cell = new Jail();
        board.add(cell);
        assertTrue(board.cells.contains(cell));
    }

    @Test
    public void getCellTypeMethodShouldReturnCellOfParticularIndexOfCells() {
        Board board = new Board();
        Cell cell = new Jail();
        Cell otherCell = new Treasure();
        board.add(cell);
        board.add(otherCell);
        assertEquals(cell,board.getCell(0));
        assertEquals(otherCell,board.getCell(1));
    }

    @Test
    public void getPlayerPositionMethodShouldReturnPlayerPositionWithDiceOutput() {
        Board board = new Board();
        Player player = new Player();
        assertEquals(5,board.getPlayerPosition(player,5));

    }
}