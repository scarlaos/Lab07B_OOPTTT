import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {
    ScoreBoard scoreboard;
    Player x;
    Player o;

    @Test
    public void testAddWins(){
        scoreboard = new ScoreBoard();
        x = new Player("Player X","X");
        o = new Player("Player O","O");
        scoreboard.addXWins(p);
        scoreboard.addTies();

        assertEquals(1,scoreboard.getxWins());
        assertEquals(1, scoreboard.getoWins());
        assertEquals(1,scoreboard.getTies());

    }
    @Test
    public void testReset(){
        scoreboard = new ScoreBoard();
        x = new Player("Player X","X");
        o = new Player("Player O","O");
        scoreboard.addXWins(p);
        scoreboard.addTies();
        scoreboard.addTies();
        scoreboard.resetScores();
        assertEquals(0,scoreboard.getxWins());
        assertEquals(0,scoreboard.getoWins());
        assertEquals(0,scoreboard.getTies());
    }
}
