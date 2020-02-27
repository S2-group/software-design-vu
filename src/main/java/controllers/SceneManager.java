package controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import views.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class for managing scenes.
 */
public class SceneManager {

    /**
     * Singleton instance.
     */
    private static final SceneManager INSTANCE = new SceneManager();

    private final Scene mainMenuScene = new Scene(new MainMenuPane(), 800 / 2.0, 600);

    private Map<Class<? extends GamePane>, Scene> scenes = new HashMap<Class<? extends GamePane>, Scene>(){{ put(MainMenuPane.class, mainMenuScene);}};

    /**
     * Primary stage.
     */
    private Stage stage;

    /**
     * Sets the primary stage.
     *
     * @param stage Primary stage.
     */
    public void setStage(final Stage stage) {
        if (this.stage != null) {
            throw new IllegalStateException("Primary stage is already initialized!");
        }

        this.stage = stage;
    }

    /**
     * Replaces the currently active {@link Scene} with another one.
     *
     * @param scene New scene to display.
     */
    private void showScene(final Scene scene) {
        if (stage == null) {
            return;
        }

        stage.hide();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Replaces the current {@link GamePane} with another one.
     *
     * @param pane New pane to display.
     */
    public void showPane(final Class<? extends GamePane> pane) {
        // TODO
        showScene(scenes.get(pane));
    }

    public <T> T getPane( final Class<? extends GamePane> pane) {
        //noinspection unchecked
        return (T) scenes.get(pane).getRoot();
    }

    public static SceneManager getInstance() {
        return INSTANCE;
    }
}
