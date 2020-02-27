import java.util.*;

public class Room {
    private String name;
    private HashMap<String, Item> items;
    private ArrayList<Room> nextRooms;
    private String script;

    public Room(String name, HashMap<String, Item> items, ArrayList<Room> nextRooms, String script) {
        this.name = name;
        this.items = items;
        this.nextRooms = nextRooms;
        this.script = script;
    }

    public Item getRoomFromName(String roomName) {
        return items.get(roomName);
    }

    public ArrayList<Room> getNextRooms() {
        return nextRooms;
    }


}
