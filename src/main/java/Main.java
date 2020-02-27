import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

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
            if (jsonFile.exists()){
//                    do stuff here
            }
            System.out.println("ok");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}