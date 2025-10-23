
public class TennisGame2 implements TennisGame
{
    public int playerOnePoints = 0;
    public int P2point = 0;
    
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
        if (playerOnePoints == P2point && playerOnePoints < 4)
        {
            if (playerOnePoints==0)
                score = "Love";
            if (playerOnePoints==1)
                score = "Fifteen";
            if (playerOnePoints==2)
                score = "Thirty";
            score += "-All";
        }
        if (playerOnePoints==P2point && playerOnePoints>=3)
            score = "Deuce";
        
        if (playerOnePoints > 0 && P2point==0)
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
        if (P2point > 0 && playerOnePoints==0)
        {
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (playerOnePoints>P2point && playerOnePoints < 4)
        {
            if (playerOnePoints==2)
                P1res="Thirty";
            if (playerOnePoints==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point>playerOnePoints && P2point < 4)
        {
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (playerOnePoints==1)
                P1res="Fifteen";
            if (playerOnePoints==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        if (playerOnePoints > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > playerOnePoints && playerOnePoints >= 3)
        {
            score = "Advantage player2";
        }
        
        if (playerOnePoints>=4 && P2point>=0 && (playerOnePoints-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && playerOnePoints>=0 && (P2point-playerOnePoints)>=2)
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
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}