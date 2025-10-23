
public class TennisGame2 implements TennisGame
{
    public int playerOnePoints = 0;
    public int playerTwoPoints = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (playerOnePoints == playerTwoPoints && playerOnePoints < 4)
        {
            if (playerOnePoints==0)
                score = "Love";
            if (playerOnePoints==1)
                score = "Fifteen";
            if (playerOnePoints==2)
                score = "Thirty";
            score += "-All";
        }
        if (playerOnePoints==playerTwoPoints && playerOnePoints>=3)
            score = "Deuce";
        
        if (playerOnePoints > 0 && playerTwoPoints==0)
        {
            if (playerOnePoints==1)
                P1res = "Fifteen";
            if (playerOnePoints==2)
                P1res = "Thirty";
            if (playerOnePoints==3)
                P1res = "Forty";
            
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (playerTwoPoints > 0 && playerOnePoints==0)
        {
            if (playerTwoPoints==1)
                P2res = "Fifteen";
            if (playerTwoPoints==2)
                P2res = "Thirty";
            if (playerTwoPoints==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (playerOnePoints>playerTwoPoints && playerOnePoints < 4)
        {
            if (playerOnePoints==2)
                P1res="Thirty";
            if (playerOnePoints==3)
                P1res="Forty";
            if (playerTwoPoints==1)
                P2res="Fifteen";
            if (playerTwoPoints==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (playerTwoPoints>playerOnePoints && playerTwoPoints < 4)
        {
            if (playerTwoPoints==2)
                P2res="Thirty";
            if (playerTwoPoints==3)
                P2res="Forty";
            if (playerOnePoints==1)
                P1res="Fifteen";
            if (playerOnePoints==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        if (playerOnePoints > playerTwoPoints && playerTwoPoints >= 3)
        {
            score = "Advantage player1";
        }
        
        if (playerTwoPoints > playerOnePoints && playerOnePoints >= 3)
        {
            score = "Advantage player2";
        }
        
        if (playerOnePoints>=4 && playerTwoPoints>=0 && (playerOnePoints-playerTwoPoints)>=2)
        {
            score = "Win for player1";
        }
        if (playerTwoPoints>=4 && playerOnePoints>=0 && (playerTwoPoints-playerOnePoints)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        playerOnePoints++;
    }
    
    public void P2Score(){
        playerTwoPoints++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}