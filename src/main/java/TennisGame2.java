
public class TennisGame2 implements TennisGame {
    public class Player {
        String name;
        int points;
        public Player(String playerName, int playerPoints) {
            this.name = playerName;
            this.points = playerPoints;
        }
    }

    public String playerOneResult = "";
    public String playerTwoResult = "";
    public Player playerOne;
    public Player playerTwo;

    public TennisGame2(String player1Name, String player2Name) {
        this.playerOne = new Player(player1Name, 0);
        this.playerTwo = new Player(player2Name, 0);
    }

    public String getScore() {
        String score = "";
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
            if (playerOne.points >= 4 && playerTwo.points >= 0 && (playerOne.points - playerTwo.points) >= 2) {
                return winForPlayer(playerOne.name);
            } else if (playerTwo.points >= 3) {
                return advantageForPlayer(playerOne.name);
            } else if (playerOne.points > 0 && playerTwo.points == 0) {
                return leadingToLove(playerOne.points, playerOne.name);
            } else {
                return leadingInGame(playerOne, playerTwo);
            }

        } else {
            if (playerTwo.points >= 4 && playerOne.points >= 0 && (playerTwo.points - playerOne.points) >= 2) {
                return winForPlayer(playerTwo.name);
            } else if (playerOne.points >= 3) {
                return advantageForPlayer(playerTwo.name);
            } else if (playerTwo.points > 0 && playerOne.points == 0) {
                return leadingToLove(playerTwo.points, playerTwo.name);
            } else {
                return leadingInGame(playerTwo, playerOne);
            }
        }
        return score;
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
        if(leadingPlayer.equals(playerOne)) {
            return leadingResult + "-" + losingResult;
        } else {
            return losingResult + "-" + leadingResult;
        }
    }

    public String winForPlayer(String playerName) {
        return "Win for " + playerName;
    }

    public String advantageForPlayer(String playerName) {
        return "Advantage " + playerName;
    }

    public String leadingToLove(int leadingPoints, String leadingPlayerName) {
        String leadingResult;
        if (leadingPoints == 1)
            leadingResult = "Fifteen";
        else if (leadingPoints == 2)
            leadingResult = "Thirty";
        else
            leadingResult = "Forty";

        if (leadingPlayerName == playerOne.name) {
            return leadingResult + "-Love";
        } else {
            return "Love-" + leadingResult;
        }
    }

    public void incrementPlayerScore(Player player) {
        player.points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            incrementPlayerScore(playerOne);
        else
            incrementPlayerScore(playerTwo);
    }
}