import java.util.ArrayList;

abstract class Entity {
    private String name;
    private ArrayList<Attack> attacks;
    private int attackDamage;
    private int manaPoints;
    private int healthPoints;
    private int lvl;
    private int maxHealthPoints;

    public Entity(String name, ArrayList<Attack> attacks, int dam, int mana, int health, int lvl) {
        this.name = name;
        this.attacks = attacks;
        attackDamage = dam;
        manaPoints = mana;
        healthPoints = health;
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return attackDamage * lvl;
    }

    public int getManaPoints(){
        return manaPoints;
    }

    public int getHealthPoints(){
        return healthPoints;
    }
    public int getMaxHealthPoints(){
        return maxHealthPoints;
    }

    public int getLVL(){
        return lvl;
    }
    
    public Attack getAttack(int index) {
        return attacks.get(index);
    }

    public void attack(Attack atk, NPC target) {
        manaPoints -= atk.getManaCost();
        target.takeDamage(atk);
    }

    public void attack(Entity attacker, Attack attack, Entity target) {
        attacker.manaPoints -= attack.getManaCost();
        target.healthPoints -= attack.getDamage();
    }
}
