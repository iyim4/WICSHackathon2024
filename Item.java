
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
        this.healthPoints = healthPoints;
        this.manaPoints = manaPoints;
        this.numUses = numUses;
        this.price = price;
    }

    /**
     * constructor for files
     * @param args must appear in order: name, health, mana, numuses, price, description
     */
    public Item(String[] args) {
        this.name = args[0];
        this.healthPoints = Integer.parseInt(args[1]);
        this.manaPoints = Integer.parseInt(args[2]);
        this.numUses = Integer.parseInt(args[3]);
        this.price = Integer.parseInt(args[4]);
        this.description = args[5];
    }

    public String getDescription(){
        return description;
    }

    public int getPrice(){
        return price;
    }

    public String getName() {
        return name;
    }

    public int getNumUses() {
        return numUses;
    }

    // returns true if this item should be removed
    public boolean use(Entity target) {
        System.out.println("Using " + name + " on " + target.getName());
        target.itemModifyHealthMana(healthPoints, manaPoints);
        numUses--;
        // print target's stats? or is the target's stats already printed at end of round?
        return numUses <= 0;
    }
}
