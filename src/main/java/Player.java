import java.util.*;

public class Player {
    private String name;
    private ArrayList<Item> inventory;
    private Room currentRoom;

    public Player(String name, ArrayList<Item> inventory, Room currentRoom) {
        this.name = name;
        this.inventory = inventory;
        this.currentRoom = currentRoom;
    }

    public ArrayList<Item> getItems() { return inventory; }

    public Room getCurrentRoom() { return currentRoom; }

    public void setCurrentRoom(Room room) { this.currentRoom = room; }

}
