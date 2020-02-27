package views;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import controllers.SceneManager;

/**
 * Pane for displaying the main menu.
 */
public class MainMenuPane extends GamePane {

    private final VBox container = new VBox();

    private final Label title = new Label("Fantasy Soccer");

    private final Button leagueSimulatorButton = new Button("League simulator");

    private final Button teamEditorButton = new Button("Team Editor");

    private final Button playerEditorButton = new Button("Player editor");

    private final Button quitButton = new Button("Quit");

    public MainMenuPane() {
        connectComponents();
        styleComponents();
        setCallbacks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void connectComponents() {
        // TODO
        container.getChildren().addAll(title, leagueSimulatorButton, teamEditorButton, playerEditorButton, quitButton);
        container.setAlignment(Pos.CENTER);
        this.setCenter(container);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    void styleComponents() {

        String bigButton = "    -fx-font-size: 15;\n" +
                "    -fx-font-family: sans-serif;\n" +
                "    -fx-pref-width: 200;\n" +
                "    -fx-pref-height: 40;\n" +
                "    -fx-background-radius: 16px;";

        container.setStyle("    -fx-background-color: #ddd;\n" +
                "    -fx-alignment: center;\n" +
                "    -fx-spacing: 20;");
        leagueSimulatorButton.setStyle(bigButton);
        teamEditorButton.setStyle(bigButton);
        playerEditorButton.setStyle(bigButton);
        quitButton.setStyle(bigButton);
        title.setStyle("-fx-font-size: 25;");

    }

    /**
     * {@inheritDoc}
     */
    @Override
    void setCallbacks() {
        // TODO
        leagueSimulatorButton.setOnMouseClicked(event -> SceneManager.getInstance().showPane(LeagueSimulatorPane.class));
        quitButton.setOnMouseClicked(mouseEvent -> Platform.exit());
    }
}
