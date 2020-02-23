import java.util.Random;

public class Match {

    private Team team1;
    private Team team2;

    public Match(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }

    public String getMatchWinner(){
        if( team1.getTeamScore() == team2.getTeamScore() )
            return new Random().nextBoolean() ? team1.getTeamName() : team2.getTeamName();
        return (team1.getTeamScore() > team2.getTeamScore() ? team1.getTeamName() : team2.getTeamName());
    }


}
