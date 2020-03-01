import java.io.*;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
//import org.json.*;
//import org.apache.commons.io.FileUtils;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;



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

                System.out.println("ok");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}