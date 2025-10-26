public class ScoreBoard {
    private int xWins = 0;
    private int oWins = 0;
    private int ties = 0;

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
        if(p.getName().equals("X")){
            xWins++;
        }else if(p.getName().equals("O")){
            oWins++;
        }
    }

    public void resetScores(){
        this.xWins = 0;
        this.oWins = 0;
        this.ties = 0;
    }
}
