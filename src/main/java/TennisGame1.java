
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
        String score = "";
        if (player1Score==player2Score)
        {
            score = getScoreTiedString(player1Score);
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            int scoreDifference = player1Score-player2Score;
            if (scoreDifference==1) score ="Advantage player1";
            else if (scoreDifference ==-1) score ="Advantage player2";
            else if (scoreDifference>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) {
                    score = getScoreDifferenceString(player1Score, score);
                }
                else { 
                    score+="-"; 
                    score = getScoreDifferenceString(player2Score, score);
                }
            }
        }
        return score;
    }

    public String getScoreDifferenceString(int playerScore, String scoreString) {
        switch(playerScore)
                {
                    case 0:
                        scoreString+="Love";
                        break;
                    case 1:
                        scoreString+="Fifteen";
                        break;
                    case 2:
                        scoreString+="Thirty";
                        break;
                    case 3:
                        scoreString+="Forty";
                        break;
                }
        return scoreString;
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
