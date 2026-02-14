
public class TennisGame2 implements TennisGame {
    public class Player {
        String name;
        int points;
        ScoreString result;

        public Player(String playerName, int playerPoints, ScoreString resultString) {
            this.name = playerName;
            this.points = playerPoints;
            this.result = resultString;
        }

        boolean isBeating(Player otherPlayer) {
            return points > otherPlayer.points;
        }

        boolean hasBeaten(Player otherPlayer) {
            return points >= 4 && (otherPlayer.points <= points - 2);
        }

        boolean couldWin() {
            return points >= 3;
        }
    }

    enum ScoreString {
        Love,
        Fifteen,
        Thirty,
        Forty;
    }

    public Player playerOne;
    public Player playerTwo;

    public TennisGame2(String player1Name, String player2Name) {
        this.playerOne = new Player(player1Name, 0, ScoreString.Love);
        this.playerTwo = new Player(player2Name, 0, ScoreString.Love);
    }

    public String getScore() {
        if (playerOne.points == playerTwo.points) {
            if (playerOne.couldWin()) {
                return "Deuce";
            } else {
                return playerOne.result + "-All";
            }
        } else if (playerOne.isBeating(playerTwo)) {
            return leadingScore(playerOne, playerTwo);
        } else {
            return leadingScore(playerTwo, playerOne);
        }
    }

    public String leadingScore(Player leadingPlayer, Player losingPlayer) {
        if (leadingPlayer.hasBeaten(losingPlayer)) {
            return winForPlayer(leadingPlayer.name);
        } else if (losingPlayer.couldWin()) {
            return advantageForPlayer(leadingPlayer.name);
        } else {
            return playerOne.result + "-" + playerTwo.result;
        }
    }

    public String winForPlayer(String playerName) {
        return "Win for " + playerName;
    }

    public String advantageForPlayer(String playerName) {
        return "Advantage " + playerName;
    }

    public void incrementPlayerScore(Player player) {
        player.points++;
        switch (player.points) {
            case 0:
                player.result = ScoreString.Love;
                break;
            case 1:
                player.result = ScoreString.Fifteen;
                break;
            case 2:
                player.result = ScoreString.Thirty;
                break;
            default:
                player.result = ScoreString.Forty;
                break;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName == playerOne.name)
            incrementPlayerScore(playerOne);
        else
            incrementPlayerScore(playerTwo);
    }
}