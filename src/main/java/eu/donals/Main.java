package eu.donals;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {

        List<String> textDisplay = new ArrayList<String>();
        UserInterface ui = UserInterface.getInstance();

        FileReader locationsReader = new FileReader("json-files/test-map.json");
        JSONParser jsonParser = new JSONParser();
        Loader locationLoader = new Loader();

        // imports JSONArray of locations from json file
        JSONArray locationList = (JSONArray) jsonParser.parse(locationsReader);

        Location startingLocation = locationLoader.getHomeLocation(locationList);

        GameState gameState = new GameState(ui.initGame(), startingLocation, locationList);

        ui.displayGame();

        textDisplay.add("Welcome " + gameState.getPlayer().getPlayerName());
        textDisplay.add("Type 'help' for a list of commands");
        textDisplay.add("Current location: " + gameState.getLocation().getName());
        textDisplay.add("Neighbouring locations: " + Arrays.toString(gameState.getLocation().getNeighbours()));

        ui.displayText(textDisplay);

        while(!gameState.getIsFinished()) {
            String input = ui.takeInput();
            gameState = gameState.updateGameState(new InputParser(input));
            System.out.println(); // newline
        }
    }
}

