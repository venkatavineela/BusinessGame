import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class BusinessHouse {
    private Map<Integer,Hotel> hotelsList = new HashMap<>();
    private InputOutput io;
    private Player[] players;
    Board board;
    private Cell cell ;


    public BusinessHouse(InputOutput io, Board board) {
        this.io = io;
        this.board = board;
        setBoard();
    }

     Player[] setPlayers() {
        io.display("Enter number of players");
        int numberOfPlayers = parseInt(io.getInput());
        players = new Player[numberOfPlayers];
        for (int i=0; i<numberOfPlayers; i++) {
            players[i] = new Player();
        }
        return players;
    }

    private void setBoard() {
        io.display("Enter board cells with type");
        String cells[] = io.getInput().split(",");
        for (int i=0; i<cells.length; i++) {
            switch (cells[i]) {
                case "E" :
                    cell = new EmptyCell();
                    break;
                case "H" :
                    cell = new Hotel();
                    hotelsList.put(i, (Hotel) cell);
                    break;
                case "T" :
                    cell = new Treasure();
                    break;
                case "J" :
                    cell = new Jail();
                    break;
            }
            board.add(cell);
        }
    }

    void updatePlayerPosition(Player player, int i) {
        int cellPosition = board.getPlayerPosition(player, i);
        Object obj = board.getCell(cellPosition);
            if (obj.getClass() == Hotel.class) {
                    player.play((Hotel) obj);
            } else if(obj.getClass() == Treasure.class) {
                player.play((Treasure) obj);
            }else if(obj.getClass() == Jail.class) {

                player.play((Jail) obj);

            }else if(obj.getClass() == EmptyCell.class) {
                player.play((EmptyCell) obj);
            }
        }
    }

