public class Player {
    private String name;
    private String symbol;
    private int wins = 0;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }
    public int getWins() {
        return wins;
    }

    private void addWins(int wins) {
        this.wins += wins;
    }
}
