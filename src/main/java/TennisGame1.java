
public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (player1Score==player2Score)
        {
            return getScoreTiedString(player1Score);
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            int scoreDifference = player1Score-player2Score;
            if (scoreDifference==1) return "Advantage player1";
            else if (scoreDifference ==-1) return "Advantage player2";
            else if (scoreDifference>=2) return "Win for player1";
            else return "Win for player2";
        }
        else
        {
            return getScoreDifferenceString(player1Score) + "-" + getScoreDifferenceString(player2Score);
        }
    }

    public String getScoreDifferenceString(int playerScore) {
        return switch(playerScore)
                {
                    case 0 -> "Love";
                    case 1 -> "Fifteen";
                    case 2 -> "Thirty";
                    case 3 -> "Forty";
                    default -> "";
                };
    }

    public String getScoreTiedString(int player1Score) {
        return switch (player1Score) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
        };
    }
}
