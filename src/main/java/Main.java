import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main (String[] args){
        System.out.println("Welcome to Software Design");

        Player player1 = new Player("bob", 1);
        Player player2 = new Player("ana", 2);
        Player player3 = new Player("pop", 3);
        Player player4 = new Player("kop", 4);
        Player player5 = new Player("tos", 5);

        Player[] team1players = {player1, player1, player1, player1, player1};
        Player[] team2players = {player2, player2, player2, player2, player2};
        Player[] team3players = {player3, player3, player3, player3, player3};
        Player[] team4players = {player4, player4, player4, player4, player4};

        Team team1 = new Team(team1players, "team1");
        Team team2 = new Team(team2players, "team2");
        Team team3 = new Team(team3players, "team3");
        Team team4 = new Team(team4players, "team4");

        Queue<Team> schedule = new LinkedList<>();
        schedule.add(team1);
        schedule.add(team4);
        schedule.add(team2);
        schedule.add(team3);

        League league = new League(schedule);

        Queue<Team> winners = league.getWinners();

        while (!winners.isEmpty()){
            System.out.println(winners.poll().getTeamName());
        }
        System.out.println(league.getRounds());

    }
}