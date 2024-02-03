import java.util.ArrayList;

public class NPC extends Entity {
    private boolean professor;

    /**
     * Constructor to initialize a new NPC
     */
    public NPC(String name, ArrayList<Attack> attacks, int mana, int health, int lvl) {
        super(name, attacks, mana, health, lvl) ;
        this.professor = false;
    }

    // checks if boss NPC
    public boolean isProfessor(){
        return professor;
    }
}
