
public class Item extends dataItem {
    private String name;
    private String description;
    private int healingHarmingPoints;
    private int numUses;
    private int price;
   
    // if the item is enabled
    private boolean inUse;

    public Item(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Item(String name, String description, int numTurnsAvailable, int price) {
        this.name = name;
        this.description = description;
        this.numUses = numTurnsAvailable;
        this.price = price;
    }

     public Item(String name, String description, int healingHarmingPoints, int numTurnsAvailable, int price) {
        this.name = name;
        this.description =description;
        this.healingHarmingPoints = healingHarmingPoints;
        this.numUses = numTurnsAvailable;
        this.price = price;
    }


    public String getDescription(){
        return description;
    }

    // heals the player
    public int healingPoints(Player player){
        int currHealthPoints = player.getHealthPoints(); 
        currHealthPoints += healingHarmingPoints;
        return currHealthPoints;

    }

   public void special() {
        System.out.println(name + " does nothing.");
        // update other objects if needed
    }
    public int getPrice(){
        return price;
    }
    // decrements the number of uses for the item
    public void itemInUse(){
        if (numUses == 0){
            inUse = false;
        }
        if(inUse){
            numUses--;
        }
    }
    /*public void hasZombieTotem(){
        if(hasZombieTotem && Entity.getHealthPoints() < 0){
            int maxHP = Entity.getMaxHealthPoints();
            maxHP = Entity.getHealthPoints();
            

            
        }
    }*/
}
