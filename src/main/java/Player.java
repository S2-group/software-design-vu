import java.util.*;

public class Player {
    private ArrayList<Object> objects;
    private String currentLocation;

    public Player(ArrayList<Object> objects, String currentLocation) {
        this.objects = objects;
        this.currentLocation = currentLocation;
    }

    public ArrayList<Object> getObjects() {
        return objects;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }
}
