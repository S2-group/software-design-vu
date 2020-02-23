import java.util.Arrays;

public class Team {

    private Player[] players;
    private int score;
    private int wins;
    private String teamName;

    public Team(Player[] players, String teamName){
        this.players = players;
        this.score = calculateScore();
        this.wins = 0;
        this.teamName = teamName;
    }

    private int calculateScore(){
        return Arrays.stream(players).mapToInt(Player::getScore).sum();
    }

    public int getTeamScore(){
        return score;
    }

    public int getTotalWins(){
        return wins;
    }

    public String getTeamName(){
        return teamName;
    }

    public void addNewWin(){
        wins++;
    }


}
