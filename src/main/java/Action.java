public class Action {
    private String commandName;
    private Item item;
    private Room room;

    public Action(String commandName, Item item, Room room) {
        this.commandName = commandName;
        this.item = item;
        this.room = room;
    }

    public boolean doAction(String commandName) {
        switch (commandName) {
            case "move":
                return true;
            default:
                System.out.println("The command name is invalid. Please ask for help.");
                return true;
        }
    }

    private boolean pickUp() {
        return true;
    }

    private boolean putDown() {
        return true;
    }

    private boolean use() {
        return true;
    }

    private boolean move(Room location) {
        return true;
    }

}
