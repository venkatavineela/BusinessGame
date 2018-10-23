import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerTest {
    @Test
    public void playMethodShouldInvokeDoAActionMethodFromBusiness() {
        Player player = new Player();
        Cell cell = mock(Cell.class);

        player.play(cell);

        verify(cell).doBusiness(player);
    }
}