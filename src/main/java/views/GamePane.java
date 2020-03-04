package views;

import javafx.scene.layout.BorderPane;


public abstract class GamePane extends BorderPane {

    /**
     * Connects all components into the root of a javafx.scene.Scene.
     */
    abstract void connectComponents();

    /**
     * Styles all components as required.
     */
    abstract void styleComponents();

    /**
     * Sets callbacks for all interactive components.
     */
    abstract void setCallbacks();
}
