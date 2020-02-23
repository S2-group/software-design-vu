import java.util.Queue;

public class League {

    private Queue<Match> schedule;
    private double rounds;

    public League(Queue<Match> schedule){
        this.schedule = schedule;
        this.rounds = Math.log(schedule.size());
    }

    public int getLeagueWinner(){
        //TODO
        return 0;
    }

}
