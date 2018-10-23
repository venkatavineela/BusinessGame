import org.junit.Test;

import static org.junit.Assert.*;

public class BuyHotelTest {
    Player player = new Player();
    Hotel hotel = new Hotel();
    Business business = new BuyHotel(hotel,player);


    @Test
    public void doActionMethodShouldReduce200FromPlayerCurrentMoneyAndMakeThePlayerAsHotelOwner() {
        int expectedCurrentMoney = player.currentMoney - 200;
        business.doAction();
        assertEquals(expectedCurrentMoney,player.currentMoney);
        assertEquals(player,hotel.owner);
    }
}