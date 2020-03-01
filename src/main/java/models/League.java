package models;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class League {

    private Queue<Team> initialTeams;
    private HashMap<Integer, ArrayList<Team>> winners;

    public League(Queue<Team> initialTeams){
        this.initialTeams = initialTeams;
        this.winners = new HashMap<>();
    }

    private void playRound(Queue<Team> teamsToPlay, int round){

        Queue<Team> nextRoundTeams = new LinkedList<>();

        if( winners.get(round) == null ){
            winners.put(round, new ArrayList<>());
        }

        while( !teamsToPlay.isEmpty() ){
            Match match = new Match(teamsToPlay.poll(), teamsToPlay.poll());
            Team winner = match.getMatchWinner();

            winners.get(round).add(winner);

            nextRoundTeams.add(winner);
        }

        if( nextRoundTeams.size() > 1 ){
            playRound(nextRoundTeams, round + 1);
        }

    }

    public HashMap<Integer, ArrayList<Team>> getWinners(){
        this.playRound(initialTeams, 1);
        return winners;
    }

}
