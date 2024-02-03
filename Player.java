import java.util.ArrayList;

public class Player extends Entity {
    
    private ArrayList<Item> allItems;

    // Construtors

    public Player(String n){
        super(n, attacks, 10, 10, );
        this.maxHealthPoints = 10;
        this.lvl = 10;
        attacks.add(new Attack("Punch", 5, 0, "You deck the enemy in the face"));
    }

    // TODO create getters for everything

    public int dealDamage(NPC enemy){
        return attackDamage * lvl;
    }

    public Attack getAttack(int index) {
        return attacks.get(index);
    }

    public void attack(Attack atk, NPC target) {
        manaPoints -= atk.getManaCost();
        target.takeDamage(atk);
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
    }

    public ArrayList<Item> getItems(){
        return allItems;
    }

}
