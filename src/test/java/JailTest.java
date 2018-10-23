import org.junit.Test;

import static org.junit.Assert.*;

public class JailTest {

    Player player = new Player();
    Cell cell = new Jail();

    @Test
    public void doBusinessMethodShouldReduce150FromPlayerCurrentMoney() {
        int expectedCurrentMoney = player.currentMoney - 150;
        cell.doBusiness(player);
        assertEquals(expectedCurrentMoney, player.currentMoney);
    }

}