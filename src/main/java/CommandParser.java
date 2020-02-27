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
        String keyword = command[0];

        switch (keyword) {
            case "move":
                Room currentRoom = Player.getCurrentRoom();
                String moveToRoom = command[1];
                return new Action("move", null, null);
            default:
                System.out.println("The command name is invalid. Please ask for help.");
                return new Action ("error", null, null);
        }
    }
}
