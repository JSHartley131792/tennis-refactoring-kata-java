
public class TennisGame3 implements TennisGame {
    
    private int playerOneScore;
    private int playerTwoScore;
    private String playerOneName;
    private String p2N;

    public TennisGame3(String playerOneName, String p2N) {
        this.playerOneName = playerOneName;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;
        if (playerOneScore < 4 && playerTwoScore < 4 && !(playerOneScore + playerTwoScore == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[playerOneScore];
            return (playerOneScore == playerTwoScore) ? s + "-All" : s + "-" + p[playerTwoScore];
        } else {
            if (playerOneScore == playerTwoScore)
                return "Deuce";
            s = playerOneScore > playerTwoScore ? playerOneName : p2N;
            return ((playerOneScore-playerTwoScore)*(playerOneScore-playerTwoScore) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.playerOneScore += 1;
        else
            this.playerTwoScore += 1;
        
    }

}
