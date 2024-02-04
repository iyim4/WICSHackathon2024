import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entity {
    private ArrayList<Item> inventory;
    private int money;

    public Player(String name, ArrayList<String> attacks, int mana, int health, int lvl){
        super(name, attacks, mana, health, lvl);
        this.money = 10;
    }

    // updates money with amount, can be positive or negative
    // pre: abs(amount) >= money. should be checked outside of this method
    public void updateMoney(int amount){
        money += amount;
    }

    public int getMoney(){
        return money;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void chooseItem(Entity target, Scanner console) {
        System.out.println("which item to use?");
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            System.out.printf("\t%d. %s (%d Uses Left)\n\t%s\n", i, item.getName(), 
                    item.getNumUses(), item.getDescription());
        }
        
        //default for now
        Item chosenItem = inventory.get(0);
        chosenItem.use(this); 
        // who to use it on?
        // if (option == 1) chosenItem.use(target); //use on self
        // if (option == 1) chosenItem.use(this); // use on enemy
        // exit
        
        
    }
}
