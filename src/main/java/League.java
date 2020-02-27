import java.util.LinkedList;
import java.util.Queue;

public class League {

    private Queue<Team> initialTeams;
    private Queue<Team> winners;
    private double rounds;

    public League(Queue<Team> initialTeams){
        this.initialTeams = initialTeams;
        this.winners = new LinkedList<>();
        this.rounds = Math.floor(Math.log(initialTeams.size())/Math.log(2));
    }

    public void playRound(Queue<Team> teamsToPlay){

        Queue<Team> nextRoundTeams = new LinkedList<>();;

        while( !teamsToPlay.isEmpty() ){
            Match match = new Match(teamsToPlay.poll(), teamsToPlay.poll());
            Team winner = match.getMatchWinner();
            winners.add(winner);
            nextRoundTeams.add(winner);
        }

        if( nextRoundTeams.size() > 1 ){
            playRound(nextRoundTeams);
        }

    }

    public Queue<Team> getWinners(){
        this.playRound(initialTeams);
        return winners;
    }

    public double getRounds(){
        return rounds;
    }

}
