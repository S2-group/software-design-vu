import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_MAGENTA = "\u001b[35m";

    public static JSONObject startRoom;
    public static JSONObject endRoom;

    public static HashMap<String, Room> roomMap = new HashMap<>();
    public static HashMap<String, Item> itemMap = new HashMap<>();

    public static String playerName;

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
                    HashMap<String, Item> thisItemMap = new HashMap<>();

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

                System.out.println(ANSI_BLUE + "\nWhat is your name?\n" + ANSI_RESET);

                try {
                    playerName = in.readLine();
                    System.out.println(ANSI_BLUE + "\n Welcome, " + playerName +". \n Let's begin. Your goal is to get to "
                            + endRoom.getString("name") + ".\n You are currently located at " + startRoom.getString("name")
                            + " and your inventory is currently empty.\n Type " + ANSI_MAGENTA + "'help'" +ANSI_BLUE + " if you ever need help.\n" + ANSI_RESET);
                }catch(Exception e){
                    e.printStackTrace();
                }

                Player player1 = new Player(playerName,  new ArrayList<Item>(),roomMap.get(startRoom.getString("name")));
                System.out.println(ANSI_BLUE + "\n" + startRoom.getString("script")  + "\n" + ANSI_RESET);

                mainWhile: while(!player1.getCurrentRoom().getRoomName().equals(endRoom.getString("name"))){
                    try {
                        String[] input2 = in.readLine().split("\\s+");
                        if(input2[0].equals("quit") && input2.length == 1) {
                            System.out.println(ANSI_BLUE + "\nYou lose!\n" + ANSI_RESET);
                            break mainWhile;
                        }
                        else {
                            Action.doAction(input2, player1);
                        }
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    if(player1.getCurrentRoom().getRoomName().equals(endRoom.getString("name"))){
                        System.out.println(ANSI_BLUE + "\nCONGRATULATIONS, " + playerName +  "! You made it to " + endRoom.getString("name") + "\n" + ANSI_RESET);
                    }
                }
            }else{
                System.out.println(ANSI_BLUE + "\nNot a valid json file.\n" + ANSI_RESET);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}