import org.junit.Test;

import static org.junit.Assert.*;

public class TreasureTest {
    Player player = new Player();
    Cell cell = new Treasure();
        @Test
        public void doBusinessMethodShouldAdd200ToPlayerCurrentMoney() {
            int expectedCurrentMoney = player.currentMoney + 200;
            cell.doBusiness(player);
            assertEquals(expectedCurrentMoney,player.currentMoney);
        }

}