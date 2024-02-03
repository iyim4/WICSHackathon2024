import java.util.*;

public class ItemShop {
    static ArrayList<Item> items; 

    public ItemShop(){
        items = new ArrayList<>();
        fillShop();
    }

    private static void fillShop(){
        items.add(new Item("Zombie Totem", "Even if your health goes below 0, you will stay alive."));
        items.add(new Item("Dining Hall Napkin", "a crumpled brown napkin from one of the three dining halls. Consume it to stave off hunger.", 1,1));
        items.add(new Item(""))
    }
    
 

  
}