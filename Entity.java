import java.util.ArrayList;

abstract class Entity {
    private String name;
    private ArrayList<Attack> attacks;
    private int manaPoints;
    private int healthPoints;
    private int lvl;
    private static final int MAX_HEALTH_POINTS = 400;

    public Entity(String name, ArrayList<Attack> attacks, int mana, int health, int lvl) {
        this.name = name;
        this.attacks = attacks;
        manaPoints = mana;
        healthPoints = health;
    }

    public String getName(){
        return name;
    }

    public int getDamage(Attack attack){
        return attack.getDamage() * lvl;
    }

    public int getManaPoints(){
        return manaPoints;
    }

    public int getHealthPoints(){
        return healthPoints;
    }
    public static int getMaxHealthPoints(){
        return MAX_HEALTH_POINTS;
    }

    public int getLVL(){
        return lvl;
    }

    public void incLVL(){
        lvl++;
    }

    public ArrayList<Attack> getAttacks(){
        return attacks;
    }
    
    public Attack getAttack(int index) {
        return attacks.get(index);
    }

    
    public void attack(Entity attacker, Attack attack, Entity target) {
        attacker.manaPoints -= attack.getManaCost();
        target.healthPoints -= attack.getDamage();
    }
}
