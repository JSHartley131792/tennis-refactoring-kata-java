
public class TennisGame1 implements TennisGame {

    class Player {
        private String playerName;
        private int score;
        public Player(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
        }
        boolean couldWin() {
            return score >=4;
        }
        boolean isBeating(Player opponent) {
            return score > opponent.score;
        }
        boolean hasAdvantage(Player opponent) {
            return couldWin() && Math.abs(score - opponent.score) == 1;
        }
    }

    private Player playerOne;
    private Player playerTwo;
    
    public TennisGame1(String player1Name, String player2Name) {
        this.playerOne = new Player(player1Name, 0);
        this.playerTwo = new Player(player2Name, 0);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            playerOne.score += 1;
        else
            playerTwo.score += 1;
    }

    public String getScore() {
        if (playerOne.score == playerTwo.score) {
            return tieScore(playerOne.score);
        } else if (playerOne.couldWin() || playerTwo.couldWin()) {
            if (playerOne.isBeating(playerTwo)) {
                if (playerOne.hasAdvantage(playerTwo)) 
                    return "Advantage " + playerOne.playerName;
                else 
                    return "Win for " + playerOne.playerName;
            } else {
                if (playerTwo.hasAdvantage(playerOne)) 
                    return "Advantage " + playerTwo.playerName;
                else 
                    return "Win for " + playerTwo.playerName;
            }
        } else {
            return scoreName(playerOne.score) + "-" + scoreName(playerTwo.score);
        }
    }

    public Score getScoreObject(int playerScore) {
        return switch (playerScore) {
            case 0 -> new Love();
            case 1 -> new Fifteen();
            case 2 -> new Thirty();
            default -> new Forty();
        };
    }

    public String scoreName(int playerScore) {
        Score score = getScoreObject(playerScore);
        return score.getScoreName();
    }

    public String tieScore(int player1Score) {
        Score score = getScoreObject(player1Score);
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
