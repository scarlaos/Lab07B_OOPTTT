public class ScoreBoard {
    private int xWins = 0;
    private int oWins = 0;
    private int ties = 0;

    public int getxWins() {
        return xWins;
    }

    public int getoWins() {
        return oWins;
    }

    public int getTies() {
        return ties;
    }

    public void addXWins(){
        this.xWins += 1;
    }
    public void addOWins(){
        this.oWins += 1;
    }
    public void addTies(){
        this.ties += 1;
    }

    public void addWin(Player p){
        if(p.getSymbol().equals("X")){
            addXWins();
        }else if(p.getSymbol().equals("O")){
            addOWins();
        }
    }

    public void resetScores(){
        this.xWins = 0;
        this.oWins = 0;
        this.ties = 0;
    }
}
