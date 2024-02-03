public class Item {
    String name;

    public Item(String name) {
        this.name = name;
    }

    public void special() {
        System.out.println(name + " does nothing.");
        // update other objects if needed
    }
}
