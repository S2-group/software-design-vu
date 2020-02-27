import java.util.*;

public class Player {
    public String name;
    private ArrayList<Object> inventory;
    private Room currentRoom;

    public Player(String name, ArrayList<Object> inventory, Room currentRoom) {
        this.name = name;
        this.inventory = inventory;
        this.currentRoom = currentRoom;
    }

    public ArrayList<Object> getObjects() { return inventory; }

    public Room getCurrentRoom() { return currentRoom; }

}
