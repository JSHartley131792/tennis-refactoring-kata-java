
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
            return tieScore(player1Score);
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
            return scoreName(player1Score) + "-" + scoreName(player2Score);
        }
    }

    public String scoreName(int playerScore) {
        Score score;
        switch(playerScore)
                {
                    case 0 -> score = new Love();
                    case 1 -> score = new Fifteen();
                    case 2 -> score = new Thirty();
                    default -> score = new Forty();
                };
        return score.getScoreName();
    }

    public String tieScore(int player1Score) {
        Score score;
        switch(player1Score)
                {
                    case 0 -> score = new Love();
                    case 1 -> score = new Fifteen();
                    case 2 -> score = new Thirty();
                    default -> score = new Forty();
                };
        return score.getTieString();
    }
    abstract class Score {
        String scoreName;
        abstract String getScoreName();
        String getTieString() {
            return getScoreName() + "-All";
        };
    }
    class Love extends Score {
        String scoreName;
        @Override
        public String getScoreName() {
            return "Love";
        }
    }
    class Fifteen extends Score {
        String scoreName;
        @Override
        public String getScoreName() {
            return "Fifteen";
        }
    }
    class Thirty extends Score {
        String scoreName;
        @Override
        public String getScoreName() {
            return "Thirty";
        }
    }
    class Forty extends Score {
        String scoreName;
        @Override
        public String getScoreName() {
            return "Forty";
        }
        @Override
        public String getTieString() {
            return "Deuce";
        };
    }
}
