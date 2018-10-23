import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusinessTest {

    Player player = new Player();
    Business business = new Business(player);

    @Test
    public void playerCurrentMoneyShouldBeThePlayerInitialMoney() {
        business.doAction();
        assertEquals(1000,player.currentMoney);
    }
}
