import java.util.*;

public class Room {
    private String name;
    private HashMap<String, Item> items;
    private String[] nextRooms;
    private String script;

    public Room(String name, HashMap<String, Item> items, String[] nextRooms, String script) {
        this.name = name;
        this.items = items;
        this.nextRooms = nextRooms;
        this.script = script;
    }

    public Item getItemFromName(String itemName) {

        return items.get(itemName);
    }

    public Room getNextRoomFromName(String roomName) {
        return  Main.roomMap.get(roomName);
    }

    public String[] getNextRooms() {
        return nextRooms;
    }


}
