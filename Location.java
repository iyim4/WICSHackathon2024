import java.util.Random;

public class Location {
    private String name;
    private String description;
    // implement spawn rates later. maybe 
    // use random: so 70% would be if rand < 0.7
    // private ArrayList<NPC> enemies
    Random rand = new Random();

    public Location(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void printDescription() {
        System.out.println(description);
    }

    // public NPC getEnemy() {
    //     random int, use as index
    //     if random.nextInt(10) >= 0.7? NPC ta = new NPC() : false;
    //     return ;
    // }
}
