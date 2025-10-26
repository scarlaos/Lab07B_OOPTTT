import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TicTacToeFrame extends JFrame {
    GamePlay gamePlay;;
    GameBoardPanel gameBoardPanel;
    ScoreBoard scoreBoard;
    Player playerX;
    Player playerO;

    JPanel buttonPanel;
    JPanel resetButton;
    JButton quitButton;
    JButton scoreButton;

    public TicTacToeFrame() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        playerX=new Player("Player X","X"); //names and symbol used for the players
        playerO=new Player("Player O","O");

        gameBoardPanel=new GameBoardPanel(); //setup
        gamePlay = new GamePlay(playerX,playerO,scoreBoard);
        scoreBoard=new ScoreBoard();

        buttonPanel=new JPanel();

        controllerActionListener(); // controller part to connect the logic and buttons

        add(gameBoardPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        setSize(400,400);
        setVisible(true);
    }

    private void controllerActionListener() {
        JButton[][] buttons = gameBoardPanel.getButtons();

        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                int r = row;
                int c = col;

                buttons[r][c].addActionListener((ActionEvent e) ->{
                    Player player = gamePlay.getCurrentPlayer(); // gets current player so game can use the correct order
                    if(gamePlay.makeMove(r,c)){
                        buttons[r][c].setText(gamePlay.getCurrentPlayer().getSymbol());
                    }
                }
                );
            }
        }
    }
}
