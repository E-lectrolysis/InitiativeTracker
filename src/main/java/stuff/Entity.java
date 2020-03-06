package stuff;

import java.util.Random;

public class Entity implements Comparable<Entity> {

    private String name;
    private String notes;
    private int hp;
    private int ac;
    private int initiative;
    private boolean reaction;


    /**
     * creates an instance of this object with all the things pre filled out already
     * @param name entity's name
     * @param initiative the initiative it rolled
     * @param hp its hp
     * @param ac its ac
     * @param notes additional notes
     */
    public Entity(String name,int initiative,  int hp, int ac, String notes) {
        this.name = name;
        this.hp = hp;
        this.initiative = initiative;
        this.notes = notes;
        this.reaction = true;
        this.ac = ac;
    }

    /**
     * in the case of an initiative tie
     * @return result  of tiebreak
     */
    private int tieBreak() {
        Random random = new Random();
        if(random.nextInt(2) > 0) {
            return 1;
        }
        return -1;
    }

    /**
     * this is probably the constructor that i'll end up using
     * @param name the name of the entity
     * @param initiative the initiative which it rolled
     */
    public Entity(String name, int initiative) {
        this(name, initiative, 0, 0, "");
    }

    /**
     * allows this object to be sorted in lists
     * @param e another entity to be compared against
     * @return the difference of the initiatives
     */
    @Override
    public int compareTo(Entity e) {
        int result = e.getInitiative()-this.getInitiative();
        if(result == 0 ) {
            result = tieBreak();
        }
        return result;
    }

    /**
     * so that this heckin object actually has a legible name on the list view thingy
     * @return a string which displays the creature's name along with its initiatibe
     */
    @Override
    public String toString() {
        return this.getInitiative() + " | " + this.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public boolean isReaction() {
        return reaction;
    }

    public void setReaction(boolean reaction) {
        this.reaction = reaction;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
}
