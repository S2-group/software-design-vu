package eu.donals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private List<String> inventory;
    private UserInterface ui;

    public boolean hasItem(String item) { return inventory.contains(item); }

    public String getPlayerName() { return name; }

    public Location move(String argument, GameState state) throws IOException {
        String[] currNeighbours = state.getLocation().getNeighbours();
        Loader locationLoader = new Loader();
        Location location = null;
        List<String> outputText = new ArrayList<String>();

        for (String currNeighbour: currNeighbours) {
            if (currNeighbour.equals(argument)) {
                location =  locationLoader.parseLocationByName(argument, state.getLocationList());

                outputText.add("eu.donals.Location: " + location.getName());
                outputText.add(location.getDescription());
                outputText.add("NPCs: " + location.getNpc());
                outputText.add("Locations near by: " + Arrays.toString(location.getNeighbours()));

                ui.displayText(outputText);

                return location;
            }
        }

        ui.displayText("Cannot find that place");
        return state.getLocation();
    }

    public void look(String argument, GameState state) throws IOException {
        if(argument.equals(state.getLocation().getNpc())) {
            ui.displayText(state.getLocation().getNpcAbout());
        } else {
            ui.displayText("Npc is not here");
        }
    }

    public void talk(String argument, GameState state) throws IOException {
        if(argument.equals(state.getLocation().getNpc())) {

            if(hasItem(state.getLocation().getItem())) {
                ui.displayText(state.getLocation().getReturnDialog());
            } else {
                ui.displayText(state.getLocation().getRiddle());
            }
        } else {
            ui.displayText("Npc is not here");
        }
    }

    public void say(String argument, GameState state) throws IOException {
        String correctAnswer = state.getLocation().getAnswer();
        String item = state.getLocation().getItem();

        if (correctAnswer.equals(argument)) {
            if(hasItem(item)) {
                ui.displayText("You already have " + item + " in your inventory");
            } else {
                inventory.add(item);
                ui.displayText(item + " added to inventory");
            }
        } else {
            ui.displayText("Incorrect");
        }
    }

    public void printInv(GameState state) throws IOException { ui.displayText("Inventory: " + state.getPlayer().getInventory()); }

    public List<String> getInventory() { return inventory; }

    public Player(String name) {
        this.name = name;
        inventory = new ArrayList<String>(){};
        ui = UserInterface.getInstance();
    }
}
