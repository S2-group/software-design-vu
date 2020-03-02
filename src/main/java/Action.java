import java.lang.reflect.Array;
import java.util.*;

public class Action {
    private String commandName;
    private Item item;
    private Room room;

    public Action(String commandName, Item item, Room room) {
        this.commandName = commandName;
        this.item = item;
        this.room = room;
    }

    public static void doAction(String[] command, Player player) {
        Action result;
        String keyword = command[0];

        switch (keyword) {
            case "move":
                if (command[1].equals("to")) {
                    Room currentRoom = player.getCurrentRoom();
                    String wholeName;
                    if (command.length > 3) {
                        String firstWord = command[2];
                        String secondWord = command[3];
                        wholeName = firstWord + " " + secondWord;
                    } else {
                        wholeName = command[2];
                    }
                    Room nextRoom = currentRoom.getNextRoomFromName(wholeName);

                    if (nextRoom == null) {
                        System.out.println(Main.ANSI_BLUE + "\nThe room name is invalid. Please ask for help.\n" + Main.ANSI_RESET);
                        break;
                    } else {
                        player.setCurrentRoom(nextRoom);
                        System.out.println(Main.ANSI_BLUE + "\nYou have moved to " + nextRoom.getRoomName() + ".\n" + player.getCurrentRoom().getScript() + "\n" + Main.ANSI_RESET);
                        break;
                    }
                }
                else {
                    System.out.println(Main.ANSI_BLUE + "\nDid you mean 'move to'?\n" + Main.ANSI_RESET);
                    break;
                }
            case "pick":
                if (command[1].equals("up")) {
                    Room currentRoom = player.getCurrentRoom();

                    if (command.length < 3) {
                        System.out.println(Main.ANSI_BLUE + "\nYou cannot pick up nothing.\n" + Main.ANSI_RESET);
                        break;
                    }

                    String itemName = command[2];
                    Item item = currentRoom.getItemFromName(itemName);

                    if (item == null) {
                        System.out.println(Main.ANSI_BLUE + "\nThe item name is invalid. Please ask for help.\n" + Main.ANSI_RESET);
                        break;
                    } else {
                        player.addToInventory(item);
                        currentRoom.removeItemFromRoom(itemName);
                        System.out.println(Main.ANSI_BLUE + "\nYou have picked up " + itemName + ".\n" + Main.ANSI_RESET);
                        System.out.println(Main.ANSI_BLUE + "\nYou are now holding  " + itemName + ".\n" + Main.ANSI_RESET);
                        break;
                    }

                } else {
                    System.out.println(Main.ANSI_BLUE + "\nDid you mean 'pick up'?\n" + Main.ANSI_RESET);
                    break;
                }
            case "inspect":
                if (command.length == 2) {
                    String itemName = command[1];

                    Item item = Main.itemMap.get(itemName);

                    if (item == null) {
                        System.out.println(Main.ANSI_BLUE + "\nThat item does not exist.\n" + Main.ANSI_RESET);
                        break;
                    } else {
                        System.out.println(Main.ANSI_BLUE + "\n" + item.getUsage() + "\n" + Main.ANSI_RESET);
                        break;
                    }

                } else {
                    System.out.println(Main.ANSI_BLUE + "\nDid you mean 'inspect item'?\n" + Main.ANSI_RESET);
                    break;
                }
            case "help":
                System.out.println(Main.ANSI_BLUE + "\nTo move, type 'move to <location>'.\nTo see where to move to next" +
                        "and what items are in this location, type 'look around'.\nTo add an item to your inventory, type 'pick up <item>'.\n"
                        + Main.ANSI_RESET);

                break;
            case "look":
                if (command[1].equals("around") && command.length == 2){
                    String[] roomOptions = player.getCurrentRoom().getNextRooms();
                    String roomOptionsString = roomOptions[0];
                    for (int i = 1; i < roomOptions.length; i++){
                        roomOptionsString = roomOptions[i] + ", " + roomOptionsString;
                    }
                    HashMap<String, Item> roomItems = player.getCurrentRoom().getItems();
                    String itemOptionsString = "";
                    for (String itemName : roomItems.keySet()){
                        itemOptionsString = itemName + ", " + itemOptionsString;
                    }
                    int unnecessaryComma = itemOptionsString.lastIndexOf(",");
                    String itemOptionsFinalString = itemOptionsString.substring(0, unnecessaryComma);
                    System.out.println(Main.ANSI_BLUE + "\nYou can move to " + roomOptionsString + ".\nItem(s) located" +
                            "in this room: " + itemOptionsFinalString);
                    break;
                }

            default:
                System.out.println(Main.ANSI_BLUE + "\nThe command name is invalid. Please ask for help.\n" + Main.ANSI_RESET);
        }
    }
}
