import org.junit.Test;

import static org.junit.Assert.*;

public class EnjoyTreasureTest {
    Player player = new Player();
    Business business = new EnjoyTreasure(player);
        @Test
        public void enjoyTreasureMethodShouldAdd200ToPlayerCurrentMoney() {
            int expectedCurrentMoney = player.currentMoney + 200;
            business.doAction();
            assertEquals(expectedCurrentMoney,player.currentMoney);
        }

}