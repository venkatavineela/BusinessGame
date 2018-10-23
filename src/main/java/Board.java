import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Cell> cells = new ArrayList();

    void add(Cell cell) {
        cells.add(cell);
    }

    Cell getCell(int cellPosition) {
        return cells.get(cellPosition%cells.size());
    }

    int getPlayerPosition(Player player, int i) {
        return player.cellPosition + i;
    }
}
