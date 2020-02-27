import java.util.*;

public class Player {
    private ArrayList<Object> inventory;
    private String currentLocation;

    public Player(ArrayList<Object> inventory, String currentLocation) {
        this.inventory = inventory;
        this.currentLocation = currentLocation;
    }

    public ArrayList<Object> getObjects() { return inventory; }

    public String getCurrentLocation() { return currentLocation; }

}
