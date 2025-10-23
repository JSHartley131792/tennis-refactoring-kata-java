
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
                    score = "Love";
                if (playerOnePoints == 1)
                    score = "Fifteen";
                if (playerOnePoints == 2)
                    score = "Thirty";
                score += "-All";
            }
            if (playerOnePoints >= 3) {
                score = "Deuce";
            }
        }

        if (playerOnePoints > 0 && playerTwoPoints == 0) {
            if (playerOnePoints == 1)
                playerOneResult = "Fifteen";
            if (playerOnePoints == 2)
                playerOneResult = "Thirty";
            if (playerOnePoints == 3)
                playerOneResult = "Forty";

            playerTwoResult = "Love";
            score = playerOneResult + "-" + playerTwoResult;
        }
        if (playerTwoPoints > 0 && playerOnePoints == 0) {
            if (playerTwoPoints == 1)
                playerTwoResult = "Fifteen";
            if (playerTwoPoints == 2)
                playerTwoResult = "Thirty";
            if (playerTwoPoints == 3)
                playerTwoResult = "Forty";

            playerOneResult = "Love";
            score = playerOneResult + "-" + playerTwoResult;
        }

        if (playerOnePoints > playerTwoPoints) {
            if (playerOnePoints < 4) {
                if (playerOnePoints == 2)
                    playerOneResult = "Thirty";
                if (playerOnePoints == 3)
                    playerOneResult = "Forty";
                if (playerTwoPoints == 1)
                    playerTwoResult = "Fifteen";
                if (playerTwoPoints == 2)
                    playerTwoResult = "Thirty";
                score = playerOneResult + "-" + playerTwoResult;
            }
            if (playerTwoPoints >= 3) {
                score = "Advantage " + player1Name;
            }
        }

        if (playerTwoPoints > playerOnePoints) {
            if (playerTwoPoints < 4) {
                if (playerTwoPoints == 2)
                    playerTwoResult = "Thirty";
                if (playerTwoPoints == 3)
                    playerTwoResult = "Forty";
                if (playerOnePoints == 1)
                    playerOneResult = "Fifteen";
                if (playerOnePoints == 2)
                    playerOneResult = "Thirty";
                score = playerOneResult + "-" + playerTwoResult;
            }
            if (playerOnePoints >= 3) {
                score = "Advantage " + player2Name;
            }
        }

        if (playerOnePoints >= 4 && playerTwoPoints >= 0 && (playerOnePoints - playerTwoPoints) >= 2) {
            score = "Win for " + player1Name;
        }
        if (playerTwoPoints >= 4 && playerOnePoints >= 0 && (playerTwoPoints - playerOnePoints) >= 2) {
            score = "Win for " + player2Name;
        }
        return score;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        playerOnePoints++;
    }

    public void P2Score() {
        playerTwoPoints++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}