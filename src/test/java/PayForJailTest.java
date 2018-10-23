import org.junit.Test;

import static org.junit.Assert.*;

public class PayForJailTest {

    Player player = new Player();
    Business business = new PayForJail(player);

    @Test
    public void payForJailMethodShouldReduce150FromPlayerCurrentMoney() {
        int expectedCurrentMoney = player.currentMoney - 150;
        business.doAction();
        assertEquals(expectedCurrentMoney, player.currentMoney);
    }

}