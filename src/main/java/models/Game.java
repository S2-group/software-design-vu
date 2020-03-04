package models;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Game {

    private static final Game GAME_INSTANCE = new Game();

    private ArrayList<Player> allPlayers;
    private ArrayList<Team> allTeams;
    private League league;

    public Game(){
        allPlayers = new ArrayList<>();
        allTeams = new ArrayList<>();
    }

    public void addPlayers(String pathToFile){
        //TODO
    }

    public void addTeam(Player[] players, String teamName){
        //TODO
        Team newTeam = new Team(players, teamName);
        allTeams.add(newTeam);

    }

    public void createLeague(Queue<Team> schedule){
        //TODO
        league = new League(schedule);
    }

    public HashMap<Integer, ArrayList<Team>> getLeagueResults(){
        //TODO
        return league.getWinners();
    }

    public ArrayList<Team>  generateLeaderboard(){
        //TODO
        return allTeams;
    }

    public ArrayList<String> getAllTeamNames(){
        return new ArrayList<>(allTeams.stream().map(team -> team.getTeamName()).collect(Collectors.toList()));
    }

    public Team getTeamByName(String name){

        for(Team team : allTeams){
            if(team.getTeamName().equals(name))
                return team;
        }
        return null;

    }

    public void removeTeam(String teamName){
        //TODO
    }

    public void removePlayer(String playerName){
        //TODO
    }

    public static Game getInstance() {
        return GAME_INSTANCE;
    }

}
