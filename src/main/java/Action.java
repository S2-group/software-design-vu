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

    public static String printInventory(ArrayList<Item> playerItems) {
        String playerInventory = "";
        String playerInventoryFinal;

        for (Item item : playerItems){
            playerInventory = item.getNameFromItem() + ", " + playerInventory;
        }
        int unnecessaryComma = playerInventory.lastIndexOf(",");
        playerInventoryFinal = "Your current inventory: " + playerInventory.substring(0, unnecessaryComma);

        return playerInventoryFinal;
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
                        System.out.println(Main.ANSI_BLUE + printInventory(player.getInventory())
                                + ".\n" + Main.ANSI_RESET);
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
                ArrayList<Item> playerItems = player.getInventory();
                String playerInventory = "";
                String playerInventoryFinal;
                if (playerItems.size() != 0){
                    for (Item item : playerItems){
                        playerInventory = item.getNameFromItem() + ", " + playerInventory;
                    }
                    int unnecessaryComma = playerInventory.lastIndexOf(",");
                    playerInventoryFinal = "Your current inventory: " + playerInventory.substring(0, unnecessaryComma);
                } else {
                    playerInventoryFinal = "Your current inventory is empty";
                }
                System.out.println(Main.ANSI_BLUE + "\nYou are currently located in " + player.getCurrentRoom().getRoomName() +
                        ".\n" + playerInventoryFinal + ". \n\nTo move, type " + Main.ANSI_MAGENTA +  "'move to <location>'" + Main.ANSI_BLUE +  ".\nTo see where to move to next and what items are in this location, type " + Main.ANSI_MAGENTA + "'look around'"  +
                        Main.ANSI_BLUE +  ".\nTo add an item to your inventory, type " + Main.ANSI_MAGENTA +  "'pick up <item>'" + Main.ANSI_BLUE + ".\n" + Main.ANSI_RESET);

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
                    int unnecessaryComma1 = itemOptionsString.lastIndexOf(",");
                    String itemOptionsFinalString = itemOptionsString.substring(0, unnecessaryComma1);
                    System.out.println(Main.ANSI_BLUE + "\nYou can move to " + roomOptionsString + ".\nItem(s) located" +
                            "in this room: " + itemOptionsFinalString);
                    break;
                }

            default:
                System.out.println(Main.ANSI_BLUE + "\nThe command name is invalid. Please ask for help.\n" + Main.ANSI_RESET);
        }
    }
}
