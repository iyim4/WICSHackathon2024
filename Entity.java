import java.util.ArrayList;
import java.util.Random; 

abstract class Entity {
    private String name;
    private ArrayList<String> attackNames;
    private int manaPoints;
    private int healthPoints;
    private int lvl;
    private static final int MAX_HEALTH_POINTS = 400; // to be used with zombie totem (item)

    public Entity(String name, ArrayList<String> attackNames, int mana, int health, int lvl) {
        this.name = name;
        this.attackNames = attackNames;
        this.manaPoints = mana;
        this.healthPoints = health;
        this.lvl = lvl;
    }

    /**
     * constructor for files
     * @param args must be in this order: name, manaPoints, healthPoints, lvl
     */
    public Entity(String[] args) {
        this.name = args[0];
        this.manaPoints = Integer.parseInt(args[1]);
        this.healthPoints = Integer.parseInt(args[2]);
        this.lvl = Integer.parseInt(args[3]);
    }

    // sets attacks
    public void setAttacks(ArrayList<String> attackNames) {
        this.attackNames = attackNames;
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

    public ArrayList<String> getAttackNames() {
        return attackNames;
    }

    public String getRandomAttackName() {
        Random rand = new Random();
        return attackNames.get(rand.nextInt(attackNames.size()));
    }
    
    public void attack(Entity attacker, Attack attack, Entity target) {
        System.out.printf("%s used %s on %s!\n", attacker.getName(), attack.getName(), target.getName());
        attacker.manaPoints -= attack.getManaCost();
        target.healthPoints -= attack.getDamage();
    }

    // for use with items only
    public void itemModifyHealthMana(int health, int mana) {
        this.healthPoints += health;
        this.manaPoints += mana;
    }
}
