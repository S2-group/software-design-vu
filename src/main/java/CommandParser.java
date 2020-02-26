import java.io.*;

public class CommandParser {
    String[] command;

    public CommandParser(BufferedReader input) throws IOException {
        try {
            command = input.readLine().split(" ");
        } catch (IOException e) {
            System.out.println("Invalid input argument."); //FIXME
        }
    }

    private Action parse(String[] command) {

        Action result;

        if (command[0].equals("move")) {
          return new Action(); //TODO: make this a Move action
        }
        else { return new Action(); } //TODO: make this a BadCommand action to print error to player
    }
}
