import java.util.ArrayList;
import java.util.List;

public class Board {
    List<CellType> cells = new ArrayList();

    void add(CellType cellType) {
        cells.add(cellType);
    }

    CellType getCellType(int cellPosition) {
        return cells.get(cellPosition);
    }

    int getPlayerPosition(Player player, int i) {
        return player.cellPosition + i;
    }
}
