import java.io.*;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;


// to run: hit green arrow, then type src/main/java/Amsterdam.json when prompted

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main (String[] args){

        System.out.println(ANSI_BLUE + "\n Welcome to the Text Adventure Game. \n Please enter the name of the json file you want to load. \n"
        + ANSI_RESET);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = in.readLine();
            File jsonFile = new File(input);
            int dotIndex = input.lastIndexOf(".");
            String fileType = input.substring(dotIndex+1);
            System.out.println("here");
            System.out.println(fileType);
            System.out.println(jsonFile.exists());
            if (jsonFile.exists() && fileType.equals("json")){
                System.out.println("here2");
                String content = FileUtils.readFileToString(jsonFile, "utf-8");
                JSONObject tomJsonObject = new JSONObject(content);
                String startRoom = tomJsonObject.getString("start room");
                System.out.println(startRoom);
                String endRoom = tomJsonObject.getString("end room");
                System.out.println(endRoom);

                JSONArray rooms = tomJsonObject.getJSONArray("rooms");
                for (int i = 0; i < rooms.length(); i++){
                    JSONObject room = rooms.getJSONObject(i);
                    String name = room.getString("name");
                    System.out.println("name: " + name);
                    System.out.println(room);
                }

                System.out.println("ok");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}