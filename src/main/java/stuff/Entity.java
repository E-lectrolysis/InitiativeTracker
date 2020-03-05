package stuff;

public class Entity implements Comparable<Entity> {

    private String name;
    private String notes;
    private int hp;
    private int ac;
    private int initiative;
    private boolean reaction;

    public Entity(String name,int initiative,  int hp, int ac, String notes) {
        this.name = name;
        this.hp = hp;
        this.initiative = initiative;
        this.notes = notes;
        this.reaction = true;
        this.ac = ac;
    }

    public Entity(String name, int initiative) {
        this(name, initiative, 0, 0, "");
    }

    @Override
    public int compareTo(Entity e) {
        return this.initiative - e.getInitiative();
    }

    @Override
    public String toString() {
        return super.toString();
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
