import controllers.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;
import models.Game;
import models.Player;
import views.MainMenuPane;


public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) {

        //Just for TESTING - until we get the user to upload data
        Player player1 = new Player("Player 1", 1);
        Player player2 = new Player("Player 2", 2);
        Player player3 = new Player("Player 3", 3);

        Player[] team1 = {player1};
        Player[] team2 = {player2};
        Player[] team3 = {player3};
        Player[] team4 = {player3, player1};
        Player[] team5 = {player3, player2};
        Player[] team6 = {player3, player3};
        Player[] team7 = {player3, player3, player1};
        Player[] team8 = {player3, player3, player2};

        Game.getInstance().addTeam(team1, "Team 1");
        Game.getInstance().addTeam(team2, "Team 2");
        Game.getInstance().addTeam(team3, "Team 3");
        Game.getInstance().addTeam(team4, "Team 4");
        Game.getInstance().addTeam(team5, "Team 5");
        Game.getInstance().addTeam(team6, "Team 6");
        Game.getInstance().addTeam(team7, "Team 7");
        Game.getInstance().addTeam(team8, "Team 8");

        //TESTING end

        SceneManager.getInstance().setStage(primaryStage);
        SceneManager.getInstance().showPane(MainMenuPane.class);
    }

    public static void main(String[] args) {
            Main.launch(args);
    }
}
