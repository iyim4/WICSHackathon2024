import java.util.ArrayList;

public class NPC extends Entity {
    private boolean professor;

    /**
     * Constructor to initialize a new NPC
     */
    public NPC(String name, ArrayList<String> attackNames, int mana, int health, int lvl) {
        super(name, attackNames, mana, health, lvl);
        this.professor = false;
    }

    // returns a copy of this NPC
    public NPC copyNPC() {
        return new NPC(getName(), getAttackNames(), getManaPoints(), getHealthPoints(), getLVL());
    }

    public NPC(String[] args) {
        super(args);
        this.professor = false;
    }

    // checks if boss NPC
    public boolean isProfessor(){
        return professor;
    }
    // other than summonning other tas, how else are bosses different?
    // can we just have summon ta as an attack?
}
