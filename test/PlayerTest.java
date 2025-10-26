import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void testPlayerSymbol(){
        Player p = new Player ("Player X", "X");
        assertEquals("Player X",p.getName());
        assertEquals("X",p.getSymbol());
        assertEquals(0,p.getWins());
    }

}
