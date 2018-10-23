import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {
    Player player = new Player();
    Player otherPlayer = new Player();
    Cell cell = new Hotel();

    @Test
    public void doBusinessMethodShouldReduce200FromPlayerCurrentMoney() {
        int expectedCurrentMoney = player.currentMoney - 200;
        cell.doBusiness(player);
        assertEquals(expectedCurrentMoney,player.currentMoney);
    }

    @Test
    public void doBusinessMethodShouldReduce50FromPlayerMoneyAndAdd50ToTheOwnerMoneyIfHotelIsBooked() {

        int expectedPlayerMoney = player.currentMoney - 50;

        cell.doBusiness(otherPlayer);
        int expectedOwnerMoney = otherPlayer.currentMoney + 50;

        cell.doBusiness(player);

        assertEquals(expectedPlayerMoney,player.currentMoney);
        assertEquals(expectedOwnerMoney,otherPlayer.currentMoney);

    }
}