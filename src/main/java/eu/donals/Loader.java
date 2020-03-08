package eu.donals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class Loader {

    private static Location parseLocationObject(JSONObject location) {
        JSONObject locationObject = (JSONObject) location.get("location");

        String name = (String) locationObject.get("name");
        String desc = (String) locationObject.get("description");

        JSONObject npcObject = (JSONObject) locationObject.get("npc");

        String npc_name = (String) npcObject.get("name");
        String npc_about = (String) npcObject.get("about");
        String npc_item = (String) npcObject.get("item");
        String npc_riddle = (String) npcObject.get("riddle");
        String npc_answer = (String) npcObject.get("answer");
        String npc_returnDialog = (String) npcObject.get("returnDialog");

        String items = (String) locationObject.get("items");
        String[] itemTokens = items.split(", ");

        String neigh = (String) locationObject.get("neighbours");
        String[] neighTokens = neigh.split(", ");

        return new Location(name, desc, npc_name, npc_about, npc_item, npc_riddle, npc_answer, npc_returnDialog, itemTokens, neighTokens);
    }

    public Location getHomeLocation(JSONArray locationList) {
        return Loader.parseLocationObject((JSONObject) locationList.get(0));
    }

    public Location parseLocationByName(String argument, JSONArray locationList) {
        for (Object obj : locationList) {
            Location location = Loader.parseLocationObject((JSONObject) obj);

            if (location.getName().equals(argument)) {
                return location;
            }
        }
        return null;
    }

    public List<String> parseImage() {
        // TODO: implement me!
        return null;
    }

}