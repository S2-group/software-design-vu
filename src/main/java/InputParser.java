public class InputParser {
    private char command;
    private String argument;

    public char getCommand() { return command; }
    public String getArgument() { return argument; }

    // TODO: lmao god forgive me, gotta rethink this one...
    private static char parseCommand(String userCommand) {

        char input = userCommand.charAt(0);

        switch (input) {    // TODO: add more commands :(
            case 'm':
                return 'm';
            case 'g':
                return 'g';
            case 'l':
                return 'l';
            case 't':
                return 't';
            case 'h':
                return 'h';
            case 's':
                return 's';
            case 'q':
                return 'q';
            default:
                return 'x';
        }
    }

    private static String parseArgument(String userArgument) {
        // TODO: parse for faulty argument
        return userArgument;
    }

    public InputParser(String userInput) {
        String[] inputTokenized = userInput.split(" ", 2); // limits array to 2 (ex. ["look", "Stinkey Monkey"]

        this.command = parseCommand(inputTokenized[0]);

        if (inputTokenized.length == 1) {
            this.argument = parseArgument("");
        } else {
            this.argument = parseArgument(inputTokenized[1]);
        }

    }
}
