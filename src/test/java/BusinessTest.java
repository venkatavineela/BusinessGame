import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessTest {
    @Test
    public void payForJailMethodShouldReduce150FromPlayerCurrentMoney() {
        Player player = new Player();
        Business business = new Business(player);
        int expectedCurrentMoney = player.initialMoney - 150;
        business.payForJail();
        assertEquals(expectedCurrentMoney,player.currentMoney);
    }
}
