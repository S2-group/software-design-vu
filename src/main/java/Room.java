import java.util.*

public class Room {
    private String name;
    private HashMap<String, Item> items;
    private Room[] connectsTo;
    private String script;

    public Room(String name, Item[] items, Room[] connectsTo, String script) {
        this.name = name;
        this.items = items;
        this.connectsTo = connectsTo;
        this.script = script;
    } // constructor

    public String getName() {
        return this.name;
    } // get name

    public Item getItem(String itemName) {
    }
}
