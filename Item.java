import java.util.ArrayList;
public class Item {
    String name;
    private ArrayList<Item> allItems;

    public Item(String name) {
        this.name = name;
        allItems
    }

    public void special() {
        System.out.println(name + " does nothing.");
        // update other objects if needed
    }

    public void zombieTotem(){
        System.out.println("Congratulations! Your suffering endures. Even if your health goes below 0, you will stay alive.");
    }

    public void genericItem(){

    }
    
}
