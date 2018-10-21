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
}
