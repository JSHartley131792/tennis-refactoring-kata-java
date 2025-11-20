
public class TennisGame2 implements TennisGame {
    public class Player {
        String name;
        int points;
        String result;

        public Player(String playerName, int playerPoints, String resultString) {
            this.name = playerName;
            this.points = playerPoints;
            this.result = resultString;
        }
    }

    public Player playerOne;
    public Player playerTwo;

    public TennisGame2(String player1Name, String player2Name) {
        this.playerOne = new Player(player1Name, 0, "");
        this.playerTwo = new Player(player2Name, 0, "");
    }

    public String getScore() {
        if (playerOne.points == playerTwo.points) {
            if (playerOne.points < 4) {
                if (playerOne.points == 0)
                    return "Love-All";
                if (playerOne.points == 1)
                    return "Fifteen-All";
                if (playerOne.points == 2)
                    return "Thirty-All";
            }
            if (playerOne.points >= 3) {
                return "Deuce";
            }
        } else if (playerOne.points > playerTwo.points) {
            return leadingScore(playerOne, playerTwo);
        } else {
            return leadingScore(playerTwo, playerOne);
        }
        return playerOne.result + "-" + playerTwo.result;
    }

    public String leadingScore(Player leadingPlayer, Player losingPlayer) {
        if (leadingPlayer.points >= 4
                && (leadingPlayer.points - losingPlayer.points) >= 2) {
            return winForPlayer(leadingPlayer.name);
        } else if (losingPlayer.points >= 3) {
            return advantageForPlayer(leadingPlayer.name);
        } else if (losingPlayer.points == 0) {
            return leadingToLove(leadingPlayer, losingPlayer);
        } else {
            return leadingInGame(leadingPlayer, losingPlayer);
        }
    }

    public String leadingInGame(Player leadingPlayer, Player losingPlayer) {
        String leadingResult = "";
        String losingResult = "";
        if (leadingPlayer.points == 2)
            leadingResult = "Thirty";
        if (leadingPlayer.points == 3)
            leadingResult = "Forty";
        if (losingPlayer.points == 1)
            losingResult = "Fifteen";
        if (losingPlayer.points == 2)
            losingResult = "Thirty";
        leadingPlayer.result = leadingResult;
        losingPlayer.result = losingResult;
        return playerOne.result + "-" + playerTwo.result;
    }

    public String winForPlayer(String playerName) {
        return "Win for " + playerName;
    }

    public String advantageForPlayer(String playerName) {
        return "Advantage " + playerName;
    }

    public String leadingToLove(Player leadingPlayer, Player losingPlayer) {
        String leadingResult;
        if (leadingPlayer.points == 1)
            leadingResult = "Fifteen";
        else if (leadingPlayer.points == 2)
            leadingResult = "Thirty";
        else
            leadingResult = "Forty";

        leadingPlayer.result = leadingResult;
        losingPlayer.result = "Love";
        return playerOne.result + "-" + playerTwo.result;
    }

    public void incrementPlayerScore(Player player) {
        player.points++;
    }

    public void wonPoint(String playerName) {
        if (playerName == playerOne.name)
            incrementPlayerScore(playerOne);
        else
            incrementPlayerScore(playerTwo);
    }
}