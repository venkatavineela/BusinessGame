import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class BusinessHouse {
    private Map<Integer,Hotel> hotelsList = new HashMap<>();
    private InputOutput io;
    private Player[] players;
    Board board;
    private Business business;

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

    void updatePlayerPosition(Player player, int i) {
        int cellPosition = board.getPlayerPosition(player, i);
            switch (board.getCellType(cellPosition)) {
                case HOTEL:
                    if (hotelsList.get(cellPosition).owner == null) {
                        business = new BuyHotel(hotelsList.get(cellPosition),player);
                    } else {
                        business = new RentHotel(hotelsList.get(cellPosition),player);
                    }
                    break;
                case TREASURE:
                    business = new EnjoyTreasure(player);
                    break;
                case JAIL:
                    business = new PayForJail(player);
                    break;
                case EMPTY:
                    break;
            }
            player.play(business);
        }
    }

