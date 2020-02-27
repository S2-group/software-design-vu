public class Item {
    private String name;
    private String location;
    private String usage;
    private boolean held;
    private boolean used;

    public Item(String name, String location, String usage, boolean held, boolean used) {
        held = false;
        used = false;

    }
}
