public class Action {
    private String commandName;
    private Item item;
    private Room room;

    public Action(String commandName, Item item, Room room) {
        this.commandName = commandName;
        this.item = item;
        this.room = room;
    }

    public void doAction(String[] command, Player player) {
        Action result;
        String keyword = command[0];

        switch (keyword) {
            case "move":
                Room currentRoom = player.getCurrentRoom();

                Room nextRoom = currentRoom.getNextRoomFromName(command[1]);

                if (nextRoom == null) {
                    System.out.println("The room name is invalid. Please ask for help.");
                } else {
                    player.setCurrentRoom(nextRoom);
                }

            default:
                System.out.println("The command name is invalid. Please ask for help.");
        }
    }
}
