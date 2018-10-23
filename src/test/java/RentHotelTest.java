import org.junit.Test;

import static org.junit.Assert.*;

public class RentHotelTest {
    Hotel hotel = new Hotel();
    Player player = new Player();
    Player otherPlayer = new Player();
    Business business = new RentHotel(hotel,player);

    @Test
    public void doActionMethodShouldReduce50FromPlayerMoneyAndAdd50ToTheOwnerMoney() {

        hotel.owner = otherPlayer;
        int expectedPlayerMoney = player.currentMoney - 50;
        int expectedOwnerMoney = otherPlayer.currentMoney + 50;

        business.doAction();

        assertEquals(expectedPlayerMoney,player.currentMoney);
        assertEquals(expectedOwnerMoney,hotel.owner.currentMoney);

    }
}