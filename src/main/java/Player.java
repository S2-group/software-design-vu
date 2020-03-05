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

    public List<String> get(String argument, GameState state) {

        // TODO: check if item already in inv
        String[] localItems = state.getLocation().getItems();
        for (String localItem : localItems) {

            if (localItem.equals(argument)) {
                System.out.println("Picked up " + localItem);

                List<String> newInv = inventory;
                newInv.add(localItem);
                return newInv;
                // TODO: remove item from location
            }
        }
        System.out.println("Item not found");
        return inventory;
    }

    // only gets npc description, does not initialize npc
    public void look(String argument, GameState state) {
//        NpcLoader npcLoader = new NpcLoader();
//
//        NPC npc = npcLoader.parseJsonByName(argument, state.getNpcList());
//
//        // if npc ask for is in current location
//        if (npc.getName().equals(state.getLocation().getNpc())) {
//            System.out.println(npc.getDescription());
//        } else {
//            System.out.println("Npc is not here");
//        }
        if(argument.equals(state.getLocation().getNpc())) {
            System.out.println(state.getLocation().getNpcAbout());
        } else {
            System.out.println("Npc is not here");
        }
    }

    // initialize npc and gets riddle
    public void talk(String argument, GameState state) {
//        NPC npc = getLocalNpcObject(argument, state);
//        if (npc == null) return;
//
//        // if npc ask for is in current location
//        if (npc.getName().equals(state.getLocation().getNpc())) {
//
//
//            // conditional interaction
//            if (npc.getNumInteractions() == 0) {
//                System.out.println(npc.getRiddle());
//                npc.setNumInteractions(npc.getNumInteractions() + 1);
//
//            } else if (npc.getNumInteractions() > 0) {
//                System.out.println(npc.getReturnDialog());
//                npc.setNumInteractions(npc.getNumInteractions() + 1);
//            }
//        }
//        else {
//            System.out.println("Npc is not here");
//        }
        if(argument.equals(state.getLocation().getNpc())) {
            //check if u have it in your inventory otherwise print
            System.out.println(state.getLocation().getRiddle());
        } else {
            System.out.println("Npc is not here");
        }
    }

    // uses ALREADY initialize npc, gets item with correct answer
//    public List<String> say(String argument, GameState state) {

//        String[] argTokenized = argument.split(" ", 2);;

//        NPC npc = state.getNpc();   // npc has to be set (by look or talk)
//        if (npc == null) {
//            System.out.println("Say " + argument + " to whom?");
//            return inventory; // inventory not updated
//        }
//
//        String correctAnswer = state.getLocation().getAnswer();
//
//        if (correctAnswer.equals(argument)) {
//            System.out.println(state.getLocation().getItem() + " added to inventory");
//
//            List<String> newInv = inventory;
//            newInv.add(state.getLocation().getItem());
//            return newInv;
//        }
//        // incorrect answer
//        System.out.println("Incorrect");
//        return inventory;
//    }
    public void say(String argument, GameState state) {

//        String[] argTokenized = argument.split(" ", 2);;

//        NPC npc = state.getNpc();   // npc has to be set (by look or talk)
//        if (npc == null) {
//            System.out.println("Say " + argument + " to whom?");
//            return inventory; // inventory not updated
//        }
        String correctAnswer = state.getLocation().getAnswer();
        String item = state.getLocation().getItem()
        if (correctAnswer.equals(argument)) {
            inventory.add();
            System.out.println(state.getLocation().getItem() + " added to inventory");
        } else {
            System.out.println("Incorrect");
        }
    }

    public void setInventory(List<String> inventory) { this.inventory = inventory; }
    public List<String> getInventory() { return inventory; }

//    private String[] itemToInv(int n, String[] oldInv, String item) {
//        String[] newInv = new String[n + 1];
//
//        if (n >= 0) System.arraycopy(oldInv, 0, newInv, 0, n);
//        newInv[n] = item;
//
//        return newInv;
//    }

//    private NPC initializeNpc(String argument, GameState state) { // initializeNpcToState ?
//        NpcLoader npcLoader = new NpcLoader();
//        NPC npc = npcLoader.parseJsonByName(argument, state.getNpcList());
//        state.setNpc(npc);
//
//        return npc;
//    }

//    private NPC getLocalNpcObject(String argument, GameState state) {
//        String localNpc = state.getLocation().getNpc();
//
//        if (!localNpc.equals(argument)) {
//            System.out.println("That npc is not here");
//            return null;
//        }
//
//        NPC npc;
//        if (state.getNpc() == null) {
//            npc = initializeNpc(argument, state);
//        } else {
//            npc = state.getNpc();
//        }
//        return npc;
//    }

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<String>(){};
    }
}
