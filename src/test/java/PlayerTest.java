import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerTest {
    @Test
    public void playMethodShouldInvokeDoAActionMethodFromBusiness() {
        Business business = mock(Business.class);
        Player player = new Player();

        player.play(business);

        verify(business).doAction();
    }
}