import org.json.simple.JSONArray;

public class GameState {

    private Player player;
    private Location location;
//    private NPC npc;
    private JSONArray locationList;
//    private JSONArray npcList;
    private boolean isFinished;

    private int numRedo;
    private Location[] locationsVisited;

    public GameState updateGameState(InputParser parsedInput) {
        GameState newGameState = this;

        switch (parsedInput.getCommand()) {
            case 'm':
                newGameState.setLocation(player.move(parsedInput.getArgument(), this));
                break;
            case 'g':
                newGameState.player.setInventory(player.get(parsedInput.getArgument(), this));
                break;
            case 'l':
                player.look(parsedInput.getArgument(), newGameState);   // NB! this changes npc var which is not explicit from func. name
                break;
            case 't':
                player.talk(parsedInput.getArgument(), newGameState);   // NB! this changes npc var which is not explicit from func. name
                break;
            case 's':
                player.say(parsedInput.getArgument(), newGameState);
                //newGameState.player.setInventory(player.say(parsedInput.getArgument(), this));
                break;
            case 'q':
                this.isFinished = true;
                break;
            case 'h':
                printHelpMessage();
                break;
            default:
                System.out.println("FUCK -- updateGameState");
                System.exit(1);
        }

        return newGameState;
    }

    private void printHelpMessage() {
        System.out.println("legal commands: " +
                "\n\tmove [location] - Move to that location" +
                "\n\tget [item] - Get item from current location" +
                "\n\tlook [npc] - Look at npc at current location" +
                "\n\ttalk [npc] - Talk to npc at location" +
                "\n\thelp - Display help message" +
                "\n\tquit - Quit game");
    }

    // get, set methods
    public Location getLocation() { return location; }
    public String getNpc() { return location.getNpc(); }
    public JSONArray getLocationList() { return locationList; }
//    public JSONArray getNpcList() { return npcList; }
    public Player getPlayer() { return player; }
    public boolean getIsFinished() { return isFinished; }

    public void setLocation(Location location) { this.location = location; }
//    public void setNpc(NPC npc) { this.npc = npc; }
    public void setPlayer(Player player) { this.player = player; }
    public void setFinished(boolean finished) { isFinished = finished; }

    // constructor
    public GameState(String name, Location location, int numRedo, Location[] locationsVisited, JSONArray locationList) {
        this.player = new Player(name);
        this.location = location;
        this.numRedo = numRedo;
        this.locationsVisited = locationsVisited;
        this.locationList = locationList;
//        this.npcList = npcList;
        this.isFinished = false;
    }

}
