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
    JButton resetButton;
    JButton quitButton;
    JButton scoreButton;

    public TicTacToeFrame() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        playerX=new Player("Player X","X"); //names and symbol used for the players
        playerO=new Player("Player O","O");

        scoreBoard=new ScoreBoard();

        gamePlay = new GamePlay(playerX,playerO,scoreBoard);

        gameBoardPanel=new GameBoardPanel(); //setup


        buttonPanel=new JPanel();
        resetButton = new JButton("Reset");
        quitButton = new JButton("Quit");
        scoreButton = new JButton("Scoreboard");
        buttonPanel.add(resetButton);
        buttonPanel.add(quitButton);
        buttonPanel.add(scoreButton);

        controllerActionListener(); // controller part to connect the logic and buttons
        resetButtonListener();
        scoreBoardListener();
        quitButtonListener();


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
                        buttons[r][c].setText(player.getSymbol());
                    }
                }
                );
            }
        }
    }

    private void resetButtonListener(){
        resetButton.addActionListener((ActionEvent e) -> {
           gamePlay.resetBoard();
            JButton[][] buttons = gameBoardPanel.getButtons();
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    buttons[i][j].setText("");//clears buttons for all button indexes of rows and cols
                }
            }

        });
    }

    private void scoreBoardListener(){
        scoreButton.addActionListener((ActionEvent e) -> {
           String scoreMessage = "Scores:\n" + "Player X Wins:" + scoreBoard.getxWins() + "\n" + "Player O Wins: " + scoreBoard.getoWins() + "\n" + "Ties: " + scoreBoard.getTies();
           JOptionPane.showMessageDialog(this, scoreMessage,"Scoreboard",JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void quitButtonListener(){
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}

