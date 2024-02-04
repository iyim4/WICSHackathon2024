import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    private String name;
    private String description;
    // implement spawn rates later. maybe 
    // use random: so 70% would be if rand < 0.7
    private ArrayList<String> localNPCs;

    public Location(String name){
        this.name = name;
    }

    // Constructor for files. Must be in order: name, description
    public Location(String[] args) {
        name = args[0];
        description = args[1];
        for (int i = 2; i < args.length; i++) {
            localNPCs.add(args[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void printDescription() {
        System.out.println(description);
    }

    public NPC getRandomLocalNPC(HashMap<String, NPC> allNPCs) {
        Random rand = new Random();
        NPC randLocalNPC = allNPCs.get(localNPCs.get(rand.nextInt(localNPCs.size())));
        return randLocalNPC.copyNPC();
    }
}
