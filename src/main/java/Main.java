import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;


// to run: hit green arrow, then type src/main/java/Amsterdam.json when prompted

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static JSONObject startRoom;
    public static JSONObject endRoom;

    public static void main (String[] args){

        System.out.println(ANSI_BLUE + "\n Welcome to the Text Adventure Game. \n Please enter the name of the json file you want to load. \n"
        + ANSI_RESET);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = in.readLine();
            File jsonFile = new File(input);
            int dotIndex = input.lastIndexOf(".");
            String fileType = input.substring(dotIndex+1);
            if (jsonFile.exists() && fileType.equals("json")){
                String content = FileUtils.readFileToString(jsonFile, "utf-8");
                JSONObject tomJsonObject = new JSONObject(content);

                String start = tomJsonObject.getString("start room");
                String end = tomJsonObject.getString("end room");

                HashMap<String, Room> roomMap = new HashMap<>();
                HashMap<String, Item> itemMap = new HashMap<>();

                JSONArray rooms = tomJsonObject.getJSONArray("rooms");
                for (int i = 0; i < rooms.length(); i++){
                    JSONObject room = rooms.getJSONObject(i);
                    String name = room.getString("name");
                    if (name.equals(start)){
                        startRoom = room;
                    } else if (name.equals(end)){
                        endRoom = room;
                    }

                    String script = room.getString("script");

                    JSONArray items = room.getJSONArray("items");
                    HashMap<String, Item> thisItemMap = new HashMap<String, Item>();

//                    initialize items (poor time complexity)
                    for (int j = 0; j < items.length(); j++){
                        JSONObject item = items.getJSONObject(j);
                        String itemName = item.getString("name");
                        String usage = item.getString("usage");
                        thisItemMap.put(itemName, new Item(itemName, name, usage));
                        itemMap.put(itemName, new Item(itemName, name, usage));
                    }
                    JSONArray nextRoomsJson = room.getJSONArray("connects to");
                    String[] nextRooms = new String[nextRoomsJson.length()];
                    for (int k = 0; k < nextRoomsJson.length(); k++){
                        String nextName = nextRoomsJson.getString(k);
                        nextRooms[k] = nextName;
                    }
                    roomMap.put(name, new Room(name, thisItemMap, nextRooms, script));

                }
//                roomMap.forEach((key, value) -> System.out.println(key + ":" + Arrays.toString(value.getNextRooms())));
//                itemMap.forEach((key, value) -> System.out.println(key + ":" + value));

//                begin game in start room
                System.out.println(ANSI_BLUE + startRoom.getString("script")  + ANSI_RESET);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

//

    }
}