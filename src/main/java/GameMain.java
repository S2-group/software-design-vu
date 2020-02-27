import controllers.SceneManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.MainMenuPane;

import java.util.ArrayList;
import java.util.Arrays;


public class GameMain extends Application {

    @Override
    public void start(final Stage primaryStage) {
        SceneManager.getInstance().setStage(primaryStage);
        SceneManager.getInstance().showPane(MainMenuPane.class);
    }

    public static void main(String[] args) {
            GameMain.launch(args);
    }
}
