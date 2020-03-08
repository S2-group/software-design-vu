package eu.donals;

import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameState {

    private Player player;
    private Location location;
    private JSONArray locationList;
    private boolean isFinished;
    private int numRedo;

    public GameState updateGameState(InputParser parsedInput) throws IOException {
        GameState newGameState = this;

        switch (parsedInput.getCommand()) {
            case MOVE:
            case GO:
                newGameState.setLocation(player.move(parsedInput.getArgument(), newGameState));
                break;
            case LOOK:
                player.look(parsedInput.getArgument(), newGameState);
                break;
            case TALK:
                player.talk(parsedInput.getArgument(), newGameState);
                break;
            case SAY:
            case ANSWER:
                player.say(parsedInput.getArgument(), newGameState);
                break;
            case QUIT:
                this.isFinished = true;
                break;
            case HELP:
                printHelpMessage();
                break;
            case INV:
                player.printInv(newGameState);
                break;
            default:
                System.exit(1);

        }
        return newGameState;
    }

    private void printHelpMessage() throws IOException {
        List<String> outputText = new ArrayList<String>();
        UserInterface ui = UserInterface.getInstance();

        outputText.add("move [location] - Move to that location");
        outputText.add("look [npc] - Look at npc at current location");
        outputText.add("talk [npc] - Talk to npc at location");
        outputText.add("say [answer] - Answer the riddle to get the item" );
        outputText.add("quit - Quit game");

        ui.displayText(outputText);
    }

    public Location getLocation() { return location; }
    public String getNpc() { return location.getNpc(); }
    public JSONArray getLocationList() { return locationList; }
    public Player getPlayer() { return player; }
    public boolean getIsFinished() { return isFinished; }

    public void setLocation(Location location) { this.location = location; }
    public void setFinished(boolean finished) { isFinished = finished; }

    // constructor
    public GameState(String name, Location location, JSONArray locationList) {
        this.player = new Player(name);
        this.location = location;
        this.locationList = locationList;
        this.isFinished = false;
    }
}
