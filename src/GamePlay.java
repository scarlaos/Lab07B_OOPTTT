public class GamePlay {
    private String[][] board = new String[3][3];
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private ScoreBoard scoreBoard;
    private boolean win;
    private int moveCount=0;
    private Player[] players = new Player[2];
    private int index=0;

    public GamePlay(Player x, Player o, ScoreBoard scoreBoard) {
        this.playerX = x;
        this.playerO = o;
        this.scoreBoard = scoreBoard;
        this.currentPlayer = playerX;

        players[0] = playerX;
        players[1] = playerO;

        resetBoard();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getSymbol() {
        return players[index];
    }

    public boolean makeMove(int row, int col) {
        if(win) return false;
        if(!board[row][col].equals("")) {
            return false;
        }
        board[row][col] = currentPlayer.getName();
        moveCount++;

        if(checkWin()){
            win = true;
            scoreBoard.addWin(currentPlayer);
        }
        else if(moveCount==9){
            win = true;
            scoreBoard.addTies();
        } else if (moveCount>=7&&!possibleWin()) {
            win = true;
            scoreBoard.addTies();
        }
        else{
            switchPlayer();
        }

        return true;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public boolean checkWin() {
        //horizontal
        for(int i=0; i<3; i++) {
            if (!board[i][0].equals("") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                return true;
            }
        }
        //vertical
        for(int j=0; j<3; j++){
            if(!board[0][j].equals("") && board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
                return true;
            }
        }

        //diagonals
        //top left to bottom right
        if(!board[0][0].equals("") && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return true;
        }
        //top right to bottom left
        if(!board[0][2].equals("") && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            return true;
        }
        return false;
    }

    private boolean possibleWin() { //checks to see if a player can still win
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j].equals("")){
                    return true;
                }
            }
        }
        return false;
    }

    private void switchPlayer(){
        index = 1 -index;
        currentPlayer = players[index];
    }

    public void resetBoard() {
        board = new String[3][3]; // makes cells null
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
        currentPlayer = playerX;
        win = false;
    }

    public boolean isWin(){
        return win;
    }
}
