package views;

import javafx.scene.layout.BorderPane;

/**
 * Abstraction for a {@link BorderPane} which can act as the root of a {@link javafx.scene.Scene}.
 */
public abstract class GamePane extends BorderPane {

    /**
     * Connects all components into the {@link BorderPane}.
     */
    abstract void connectComponents();

    /**
     * Styles all components as required.
     */
    abstract void styleComponents();

    /**
     * Set callbacks for all interactive components.
     */
    abstract void setCallbacks();
}
