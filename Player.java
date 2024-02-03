import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Attack> attacks;
    private int attackDamage;
    private int manaPoints;
    private int healthPoints;
    private int lvl;

    // Construtors

    private void Player(String n){
        this.name = n;
        this.attackDamage = 1;
        this.manaPoints = 10;
        this.healthPoints = 10;
        this.lvl = 10;
        attacks.add(new Attack("Punch", 5, 0, "You deck the enemy in the face"));
    
    }

    // TODO create getters for everything

    public int getAttackDamage(){
        return attackDamage;
    }

    public int getManaPoints(){
        return manaPoints;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public int getLVL(){
        return lvl;
    }

}
