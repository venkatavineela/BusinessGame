import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

class Game {
    private Map<Integer,Hotel> hotelsList = new HashMap<>();
    private InputOutput io;
    private Player[] players;
    BusinessHouse house;

    Game(InputOutput io,BusinessHouse house) {
        this.io = io;
        this.house = house;
    }

    private int[] getDiceOutput() {
        io.display("Enter Dice output");
         int[] diceOutput;
        String diceOutputString[] = io.getInput().split(",");
        diceOutput = new int[diceOutputString.length];
        for (int i = 0; i < diceOutputString.length; i++) {
            int output = parseInt(diceOutputString[i]);
            if(output <= 12 && output >= 2) {
                diceOutput[i] = output;
            }
            else {
                return null;
            }
        }
        return diceOutput;
    }

    void start() {
        int playerCount = 0;
        players = house.setPlayers();
        int[] diceOutput = getDiceOutput();
        if(diceOutput != null) {
            for (int i = 0; i < diceOutput.length; i++) {
                house.updatePlayerPosition(players[playerCount],i);
                playerCount++;
                if(playerCount == players.length) {
                    playerCount = 0;
                }
            }
        } else {
            io.display("Enter Correct Dice output");
        }
    }

    void finalScore() {
        int maxAmount = players[0].currentMoney;
        int winner = 0;
        for (int i = 0; i < players.length; i++) {
            if(maxAmount < players[i].currentMoney) {
                maxAmount = players[i].currentMoney;
                winner = i+1;
            }
            io.display("Player-" + i+1 + "has total worth" + players[i].currentMoney);
        }
        io.display("players" + winner + "is winner");
    }


}
