package eu.donals;

public class InputParser {
    private Command command;
    private String argument;

    public enum Command {
        GO,
        MOVE,
        LOOK,
        TALK,
        SAY,
        ANSWER,
        HELP,
        INV,
        QUIT
    }

    public Command getCommand() { return command; }
    public String getArgument() { return argument; }

    private static Command parseCommand(String userCommand) {
        return Command.valueOf(userCommand.toUpperCase());
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
