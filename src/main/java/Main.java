import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        // Bunch of things needed
        FileReader locationsReader = new FileReader("src/main/json-files/test-map.json");

        JSONParser jsonParser = new JSONParser();
        LocationLoader locationLoader = new LocationLoader();
        Scanner scanner = new Scanner(System.in);

        // imports JSONArray of locations from json file
        JSONArray locationList = (JSONArray) jsonParser.parse(locationsReader);

        Location startingLocation = locationLoader.getHomeLocation(locationList);

        // start game
        GameState gameState = new GameState("Daniel", startingLocation, locationList);

        while(!gameState.getIsFinished()) {  // just to stop the IDE from complaining
            System.out.println(
                    "location: " + gameState.getLocation().getName() +
                    "\ndesc: " + gameState.getLocation().getDescription() +
                    "\nnpcs: " + gameState.getLocation().getNpc() +
                    "\nlocal items: " + Arrays.toString(gameState.getLocation().getItems()) +
                    "\nnear by: " + Arrays.toString(gameState.getLocation().getNeighbours()) +
                    "\n\ninventory: " + gameState.getPlayer().getInventory()
            );

            String input = scanner.nextLine();
            gameState = gameState.updateGameState(new InputParser(input));
            System.out.println(); // newline
        }

    }
}

