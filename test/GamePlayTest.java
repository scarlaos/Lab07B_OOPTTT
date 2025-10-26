import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GamePlayTest {
    GamePlay gameplay;
    Player x;
    Player o;
    ScoreBoard scoreboard;

    @BeforeEach
    public void setup(){
        x = new Player("Player X","X");
        o = new Player("Player O","O");
        scoreboard = new ScoreBoard();
        gameplay = new GamePlay(x,o,scoreboard);
    }

    @Test
    public void testMakeMove(){
        boolean move = gameplay.makeMove(0,0); // row,col
        assertTrue(move);
        assertEquals(1,gameplay.getMoveCount());
        assertEquals(0,gameplay.getMoveCount()); // switches to O players
    }

    @Test
    public void testHorizontalWin(){
        gameplay.makeMove(0,0);//X
        gameplay.makeMove(1,0);//O
        gameplay.makeMove(0,1);//X
        gameplay.makeMove(1,1);//O
        gameplay.makeMove(0,2);//X win

        assertTrue(gameplay.isWin());
        assertEquals(1,scoreboard.getxWins());
    }
    @Test
    public void testResetBoard(){
        gameplay.makeMove(0,0);
        gameplay.resetBoard();
        assertEquals(0,gameplay.getMoveCount());
        assertFalse(gameplay.isWin());
        assertEquals(x,gameplay.getCurrentPlayer());
    }

}
