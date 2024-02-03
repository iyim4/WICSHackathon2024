import java.util.ArrayList;

public class Player extends Entity {
    private ArrayList<Item> allItems;
    private int money;

    public Player(String name, ArrayList<Attack> attacks, int mana, int health, int lvl){
        super(name, attacks, mana, health, lvl);
        this.money = 0;
    }

    public void incMoney(int inc){
        money+=inc;
    }

    public int getMoney(){
        return money;
    }
    
    // returns the current items the player has
    public ArrayList<Item> getItems(){
        return allItems;
    }

}
