import java.util.*;

public class NPC extends Entity {
    private int lvl;
    private boolean professor;

    /**
     * Constructor to initialize a new enemy
     */

    // default
    private NPC(){
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

    // depletes player's hp
    private void dealDamage(int health){
        Random rand = new Random();
        int i = rand.nextInt(attacks.size());
        health -= attackDamage * attacks.get(i).getDamage();
    }
    
    // reduce the mana bar ? 
    private void manaUsage(int manaCost) {
        
        manaPoints -= attacks.get(0).getManaCost();
    }

    
    public boolean isProfessor(){
        return professor;
    }
    
    public void attack(Attack atk, NPC target) {
        manaPoints -= atk.getManaCost();
        target.takeDamage(atk);
    }

    // updates perspective
    public void takeDamage(Attack atk) {
        healthPoints -= atk.getDamage();
    }
}
