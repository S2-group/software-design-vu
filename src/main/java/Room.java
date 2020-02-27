import java.util.*;

public class Room {
    private String name;
    private HashMap<String, Item> items;
    private HashMap<String, Room> nextRooms;
    private String script;

    public Room(String name, HashMap<String, Item> items, HashMap<String, Room> nextRooms, String script) {
        this.name = name;
        this.items = items;
        this.nextRooms = nextRooms;
        this.script = script;
    }

    public Item getItemFromName(String itemName) {
        return items.get(itemName);
    }

    public Room getNextRoomFromName(String roomName) {
        return nextRooms.get(roomName);
    }

    public HashMap<String, Room> getNextRooms() {
        return nextRooms;
    }


}
