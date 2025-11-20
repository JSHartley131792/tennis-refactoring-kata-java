
public class TennisGame3 implements TennisGame {
    
    private int playerOneScore;
    private int playerTwoScore;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    String[] scoreStringArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 

    public String getScore() {
        if (playerOneScore < 4 && playerTwoScore < 4 && !(playerOneScore + playerTwoScore == 6)) {
            String scoreString = scoreStringArray[playerOneScore];
            return (playerOneScore == playerTwoScore) ? scoreString + "-All" : scoreString + "-" + scoreStringArray[playerTwoScore];
        } else {
            if (playerOneScore == playerTwoScore)
                return "Deuce";
            String leadingPlayer = playerOneScore > playerTwoScore ? playerOneName : playerTwoName;
            return ((playerOneScore-playerTwoScore)*(playerOneScore-playerTwoScore) == 1) ? "Advantage " + leadingPlayer : "Win for " + leadingPlayer;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.playerOneScore += 1;
        else
            this.playerTwoScore += 1;
        
    }

}
