
public class Item {
    private String name;
    private String description;
    private int healthPoints;
    private int manaPoints;
    private int numUses;
    private int price;
    
    // if the item is enabled
    private boolean inUse; // remove? since it will be in the player's "inventory"

    public Item(String name, String description, int numUses, int healthPoints, int manaPoints, int price) {
        this.name = name;
        this.description = description;
        this.manaPoints = manaPoints;
        this.healthPoints = healthPoints;
        this.numUses = numUses;
        this.price = price;
    }

    public String getDescription(){
        return description;
    }

    // returns true if this item should be removed
    public boolean use(Entity target) {
        System.out.println("Using " + name + " on " + target.getName());
        target.itemModifyHealthMana(healthPoints, manaPoints);
        numUses--;
        // print target's stats? or is the target's stats already printed at end of round?
        return numUses <= 0;
    }

    public int getPrice(){
        return price;
    }
}
