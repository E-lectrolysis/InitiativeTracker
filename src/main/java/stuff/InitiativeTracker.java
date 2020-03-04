package stuff;

import java.util.ArrayList;
import java.util.Collections;

public class InitiativeTracker {

    private ArrayList<Entity> creatures;

    public InitiativeTracker() {
        this.creatures = new ArrayList<>();
    }

    public ArrayList<Entity> getCreatures() {
        return creatures;
    }

    public void sortInitiative() {
        Collections.sort(creatures);
    }
}
