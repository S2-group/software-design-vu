import java.util.*;

public class Obstacle {
    private Item itemNeeded;
    private boolean open;

    public Obstacle(Item itemNeeded) {
        this.itemNeeded = itemNeeded;
        this.open = false;
    }
}
