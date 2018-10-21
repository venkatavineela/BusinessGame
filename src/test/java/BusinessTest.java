import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessTest {

    Player player = new Player();
    Business business = new Business(player);

    @Test
    public void payForJailMethodShouldReduce150FromPlayerCurrentMoney() {
        int expectedCurrentMoney = player.currentMoney - 150;
        business.payForJail();
        assertEquals(expectedCurrentMoney,player.currentMoney);
    }

    @Test
    public void enjoyTreasureMethodShouldAdd200ToPlayerCurrentMoney() {
        int expectedCurrentMoney = player.currentMoney + 200;
        business.enjoyTreasure();
        assertEquals(expectedCurrentMoney,player.currentMoney);
    }

    @Test
    public void buyHotelMethodShouldReduce200FromPlayerCurrentMoneyAndMakeThePlayerAsHotelOwner() {
        int expectedCurrentMoney = player.currentMoney - 200;
        Hotel hotel = new Hotel();
        business.buyHotel(hotel);
        assertEquals(expectedCurrentMoney,player.currentMoney);
        assertEquals(player,hotel.owner);
    }

    @Test
    public void playerCurrentMoneyShouldRemainSameIfHeHasNoEnoughMoneyToBuy() {
        player.currentMoney = 150;
        Hotel hotel = new Hotel();
        business.buyHotel(hotel);
        assertEquals(150,player.currentMoney);
    }
}
