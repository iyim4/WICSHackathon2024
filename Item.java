import java.util.ArrayList;
public class Item {
    String name;
  

    public Item(String name) {
        this.name = name;
        
    }

    public void special() {
        System.out.println(name + " does nothing.");
        // update other objects if needed
    }

    public void zombieTotem(){
        System.out.println("Congratulations! Your suffering endures with the help of this" + name + ".Even if your health goes below 0, you will stay alive.");
    }

    public void genericItem(){

    }
    
}
