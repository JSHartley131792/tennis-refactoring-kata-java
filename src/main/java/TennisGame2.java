
public class TennisGame2 implements TennisGame {
    public int playerOnePoints = 0;
    public int playerTwoPoints = 0;

    public String playerOneResult = "";
    public String playerTwoResult = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (playerOnePoints == playerTwoPoints) {
            if (playerOnePoints < 4) {
                if (playerOnePoints == 0)
                    return "Love-All";
                if (playerOnePoints == 1)
                    return "Fifteen-All";
                if (playerOnePoints == 2)
                    return "Thirty-All";
            }
            if (playerOnePoints >= 3) {
                return "Deuce";
            }
        } else if (playerOnePoints > playerTwoPoints) {
            if (playerOnePoints >= 4 && playerTwoPoints >= 0 && (playerOnePoints - playerTwoPoints) >= 2) {
                return winForPlayer(player1Name);
            } else if (playerTwoPoints >= 3) {
                return advantageForPlayer(player1Name);
            } else if (playerOnePoints > 0 && playerTwoPoints == 0) {
                return leadingToLove(playerOnePoints, player1Name);
            } else {
                if (playerOnePoints == 2)
                    playerOneResult = "Thirty";
                if (playerOnePoints == 3)
                    playerOneResult = "Forty";
                if (playerTwoPoints == 1)
                    playerTwoResult = "Fifteen";
                if (playerTwoPoints == 2)
                    playerTwoResult = "Thirty";
                return playerOneResult + "-" + playerTwoResult;
            }

        } else {
            if (playerTwoPoints >= 4 && playerOnePoints >= 0 && (playerTwoPoints - playerOnePoints) >= 2) {
                return winForPlayer(player2Name);
            } else if (playerOnePoints >= 3) {
                return advantageForPlayer(player2Name);
            } else if (playerTwoPoints > 0 && playerOnePoints == 0) {
                return leadingToLove(playerTwoPoints, player2Name);
            } else {
                if (playerTwoPoints == 2)
                    playerTwoResult = "Thirty";
                if (playerTwoPoints == 3)
                    playerTwoResult = "Forty";
                if (playerOnePoints == 1)
                    playerOneResult = "Fifteen";
                if (playerOnePoints == 2)
                    playerOneResult = "Thirty";
                return playerOneResult + "-" + playerTwoResult;
            }
        }
        return score;
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

        if (leadingPlayerName == player1Name) {
            return leadingResult + "-Love";
        } else {
            return "Love-" + leadingResult;
        }
    }

    public void incrementPlayerOneScore() {
        playerOnePoints++;
    }

    public void P2Score() {
        playerTwoPoints++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            incrementPlayerOneScore();
        else
            P2Score();
    }
}