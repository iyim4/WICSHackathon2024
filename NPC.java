import java.util.*;

public class NPC {
    private String name;
    private ArrayList<Attack> attacks;
    private int attackDamage;
    private int manaPoints;
    private int healthPoints;
    private int lvl;
    private boolean professor;

    /**
     * Constructor to initialize a new enemy
     */

    // default
    private void NPC(){
        this.name = "Some loser";
        this.attackDamage = 1;
        this.manaPoints = 1;
        this.healthPoints = 1;
        this.lvl = 1;
        attacks.add(new Attack("Dropkick", 1, 0, "The NPC dropkicks you"));
        this.professor = false;

    }

    // creation
    public NPC(String n, int a, int m, int h){
        this.name = n;
        this.attackDamage = a;
        this.manaPoints = m;
        this.healthPoints = h;
    }

    // updates respective
    private void takeDamage(Attack atk) {
        healthPoints -= atk.getDamage();
    }

    // depletes player's hp
    private void dealDamage(int health){
        Random rand = new Random();
        int i = rand.nextInt(attacks.size());
        health -= attackDamage * attacks.get(i).getDamage();
    }
    
    // reduce the mana bar ? 
    private void manaUsage(int manaCost) {
        
        manaPoints -= attacks.get(0).manaCost();
    }

    
    public boolean isProfessor(){
        return professor;
    }
    
}
