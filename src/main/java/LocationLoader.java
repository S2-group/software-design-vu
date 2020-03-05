import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class LocationLoader {

    public static Location parseJsonObject(JSONObject location) {
        JSONObject locationObject = (JSONObject) location.get("location");

        String name = (String) locationObject.get("name");
        String desc = (String) locationObject.get("description");
//        String npc = (String) locationObject.get("npc");
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
        return LocationLoader.parseJsonObject((JSONObject) locationList.get(0));
//        return null;
    }

    public Location parseJsonByName(String argument, JSONArray locationList) {
        for (Object obj : locationList) {
            Location location = LocationLoader.parseJsonObject((JSONObject) obj);

            if (location.getName().equals(argument)) {
                return location;
            }
        }
        return null;
    }


    public boolean stageExist(String argument, JSONArray locationList) {
        for (Object obj : locationList) {
            Location location = LocationLoader.parseJsonObject((JSONObject) obj);

            if (location.getName().equals(argument)) {
                return true;
            }
        }
        return false;
    }

}