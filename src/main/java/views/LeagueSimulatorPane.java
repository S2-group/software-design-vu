package views;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class LeagueSimulatorPane extends GamePane {

    private final VBox leftContainer = new VBox();
    private final VBox centerContainer = new VBox();

    public LeagueSimulatorPane() {
        connectComponents();
        styleComponents();
        setCallbacks();
    }

    @Override
    void connectComponents() {
        this.setLeft(leftContainer);
        this.setCenter(centerContainer);
    }

    @Override
    void styleComponents() {

    }

    @Override
    void setCallbacks() {

    }
}
