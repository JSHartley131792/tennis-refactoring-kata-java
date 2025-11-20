
public class TennisGame3 implements TennisGame {
    
    private int playerOneScore;
    private int p2;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;
        if (playerOneScore < 4 && p2 < 4 && !(playerOneScore + p2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[playerOneScore];
            return (playerOneScore == p2) ? s + "-All" : s + "-" + p[p2];
        } else {
            if (playerOneScore == p2)
                return "Deuce";
            s = playerOneScore > p2 ? p1N : p2N;
            return ((playerOneScore-p2)*(playerOneScore-p2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.playerOneScore += 1;
        else
            this.p2 += 1;
        
    }

}
