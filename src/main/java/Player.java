import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<String> inventory;

    public Location move(String argument, GameState state) {
        String[] currNeighbours = state.getLocation().getNeighbours();

        for (String currNeighbour : currNeighbours) {
            if (currNeighbour.equals(argument)) {
                LocationLoader locationLoader = new LocationLoader();
                return locationLoader.parseJsonByName(argument, state.getLocationList());
            }
        }

        System.out.println("Cant find that place");
        return state.getLocation();
    }

    public Boolean hasItem(String item) { return inventory.contains(item); }

    public void look(String argument, GameState state) {
        if(argument.equals(state.getLocation().getNpc())) {
            System.out.println(state.getLocation().getNpcAbout());
        } else {
            System.out.println("Npc is not here");
        }
    }

    // initialize npc and gets riddle
    public void talk(String argument, GameState state) {
        if(argument.equals(state.getLocation().getNpc())) {

            if(hasItem(state.getLocation().getItem())) {
                System.out.println(state.getLocation().getReturnDialog());
            } else {
                System.out.println(state.getLocation().getRiddle());
            }
        } else {
            System.out.println("Npc is not here");
        }
    }

    public void say(String argument, GameState state) {
        String correctAnswer = state.getLocation().getAnswer();
        String item = state.getLocation().getItem();

        if (correctAnswer.equals(argument)) {
            if(hasItem(item)) {
                System.out.println("You already have " + item + " in your inventory");
            } else {
                inventory.add(item);
                System.out.println(item + " added to inventory");
            }
        } else {
            System.out.println("Incorrect");
        }
    }

    public void setInventory(List<String> inventory) { this.inventory = inventory; }
    public List<String> getInventory() { return inventory; }

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<String>(){};
    }
}
