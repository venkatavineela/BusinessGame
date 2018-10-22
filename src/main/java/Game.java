import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Game {
    private List<CellType> board = new ArrayList();
    private Map<Integer,Hotel> hotelsList = new HashMap<>();
    private InputOutput io;
    private Player[] player;
    private Business[] business;
    private int diceOutput[];

    public Game(InputOutput io) {
        this.io = io;
        gameSetUp();
    }

    void gameSetUp() {
        setPlayers();
        setBoard();
        getDiceOutput();
    }

     private void setBoard() {
        io.display("Enter board cells with type");
        String cells[] = io.getInput().split(",");
        for (int i=0; i<cells.length; i++) {
            switch (cells[i]) {
                case "E" :
                    board.add(CellType.EMPTY);
                    break;
                case "H" :
                    board.add(CellType.HOTEL);
                    hotelsList.put(i,new Hotel());
                    break;
                case "T" :
                    board.add(CellType.TREASURE);
                    break;
                case "J" :
                    board.add(CellType.JAIL);
                    break;
                default  :
                    io.display("Invalid cell type");
            }
        }
    }

    private void setPlayers() {
        io.display("Enter number of players");
        int numberOfPlayers = parseInt(io.getInput());
        player = new Player[numberOfPlayers];
        business = new Business[numberOfPlayers];
        for (int i=0; i<numberOfPlayers; i++) {
            player[i] = new Player();
            business[i] = new Business(player[i]);
        }
    }

    private void getDiceOutput() {
        io.display("Enter Dice output");
        String diceOutputString[] = io.getInput().split(",");
        diceOutput = new int[diceOutputString.length];
        for (int i = 0; i < diceOutputString.length; i++) {
            int output = parseInt(diceOutputString[i]);
            if(output <= 12 && output >= 2) {
                diceOutput[i] = output;
            }
            else {
                io.display("Invalid dice output");
            }
        }
    }
}
