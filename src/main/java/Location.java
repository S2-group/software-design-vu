/*
*   TODO:
*       - add items to stages
*
*
* */

import java.util.Arrays;


public class Location {
    private String name;
    private String description;
    private NPC npc;
    private String[] items;
    private String[] neighbours;

    private class NPC {
        private String name;
        private String about;
        private String item;
        private String riddle;
        private String answer;
        private String returnDialog;

        public NPC(String name, String about, String item, String riddle, String answer, String returnDialog) {
            this.name = name;
            this.about = about;
            this.item = item;
            this.riddle = riddle;
            this.answer = answer;
            this.returnDialog = returnDialog;
        }
    }

    public void printStage() {
        System.out.println(getName() + "\n" + getDescription() + "\n" + Arrays.toString(getItems()) + "\n" + Arrays.toString(getNeighbours()));
    }

    // ------- Get and Set methods ------- //
    public void setName(String x) { this.name = x; }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public String getNpc() { return npc.name; }
    public String getNpcAbout() { return npc.about; }
    public String getRiddle() { return npc.riddle; }
    public String getReturnDialog() { return npc.returnDialog; }
    public String getAnswer() { return npc.answer; }
    public String getItem() { return npc.item; }

    public String[] getItems() { return items; }
    public String[] getNeighbours() { return neighbours; }

    // constructor
    public Location(String name, String desc, String npc_name, String npc_about, String npc_item, String npc_riddle, String npc_answer, String npc_returnDialog, String[] items, String[] neigh) {
        this.name = name;
        this.description = desc;
        this.npc = new NPC(npc_name, npc_about, npc_item, npc_riddle, npc_answer, npc_returnDialog);
        this.items = items;
        this.neighbours = neigh;
    }

}
