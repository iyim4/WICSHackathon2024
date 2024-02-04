
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // welcome message
        System.out.println("Welcome, young aspiring CS transfer student! You were thrown out by your parents," + 
                "but do not fear you shall go into debt and achieve your CS degree (hopefully). ! : ( )");

        // enemy creation (??)
        // later todo create a method that takes in datafile(.csv) and arraylist
        // HashMap<String, NPC> enemies = new HashMap<>();
        // Attack homework = new Attack("Homework", 6, 1, "The student's bane");
        // Attack slap = new Attack("Slap", 3, 0, "Who can't slap?");
        // enemies.put("Student", new NPC("Student", new ArrayList<Attack>(){{add(slap);}}, 10, 10, 10));
        // enemies.put("TA", new NPC("TA", new ArrayList<Attack>(){{add(homework);}}, 20, 20, 20));
        // enemies.put("Professor", new NPC("Professor", new ArrayList<Attack>(){{add(homework);}}, 30, 30, 30));
        // enemies.put("Janitor", new NPC("Janitor", new ArrayList<Attack>(){{add(slap);}}, 10, 10, 10) );

        // player input --> name selection
        System.out.println("\nWhat is your name? You poor innocent soul.");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        Player player = new Player(name, new ArrayList<String>(), 10, 10, 10);
        System.out.println("So your name is " + name + "?");

        // some setup
        HashMap<String, Attack> allAttacks = new HashMap<>();
        HashMap<String, NPC> allNPCs = new HashMap<>();
        HashMap<String, Item> allItems = new HashMap<>();
        ArrayList<Location> allLocations = new ArrayList<>();
        Random rand = new Random();
        ItemShop shop = new ItemShop();
        readData(allAttacks, allNPCs, allItems, allLocations);

        System.out.println("You must venture ..."); //todo
        int option = 0;
        while (option != -1) {
            // print menu (& stats?)
            // print location options
            System.out.println("\nWhat will you do?\n");
            for (int i = 1; i <= allLocations.size(); i++) {
                System.out.printf("\t%d. Go to the %s.\n", i, allLocations.get(i - 1).getName());
            }
            System.out.printf("\t%d. Go to the Item Shop.\n\n", allLocations.size());

            // get player option
            option = Integer.parseInt(console.nextLine());
            // is this the kind of validation we will use? validate
            while (option < -1 && option > allLocations.size()) {
                System.out.println("Please enter a number between 0 and " + allLocations.size() + ", or -1 to quit.");
                option = Integer.parseInt(console.nextLine());
            }

            // update
            if (option == allLocations.size()) {
                // open shop dialogue <-- wait like item shop or??? Lorena //solved, can delete this line now
                shop.runShop(player);
            } else {
                Location loc = allLocations.get(option);
                loc.printDescription();
                // get enemy from location (for weighted spawn distribution)
                // call fightEnemy
                fightEnemy(player, loc.getRandomLocalNPC(allNPCs), allAttacks, console, rand);
            }
        }
        if (option == -1) {
            // quit message
        } else {
            System.out.println("You win ig that's cool for you");
        }
        console.close();
    }

    // read in data from all files and stores it in allAttacks, allNPCs, allItems, and allLocations
    private static void readData(HashMap<String, Attack> allAttacks, HashMap<String, NPC> allNPCs,
            HashMap<String, Item> allItems, ArrayList<Location> allLocations) throws IOException{
        String path = "./data/";

        // attacks
        allAttacks = new HashMap<>();
        String filepath = path + "AttackData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            String[] list;
            while ((line = sc.readLine()) != null) {
                list = line.split(",");
                allAttacks.put(list[0], new Attack(list));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }

        // NPCs
        allNPCs = new HashMap<>();
        filepath = path + "NPCData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            String[] list;
            while ((line = sc.readLine()) != null) {
                list = line.split(",");
                allNPCs.put(list[0], new NPC(list));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }

        //debugging, delete later
        for (String a : allNPCs.keySet()) {
            System.out.print(a + ", ");
        }
        System.out.println();

        // output: "?? Major", ï»¿"Mike Scott", "Art Major", "Carol Ramsey", "Business Major", "? Major",
        //~~~~~~~~~~~~~~~~~~~~ ^
        // what is this gibberish?? let's solve tomorrow


        // NPCs' attacks
        filepath = path + "NPCAttackData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            String[] list;
            while ((line = sc.readLine()) != null) {
                list = line.split(",");
                ArrayList<String> tempAttacks = new ArrayList<>();
                for (int i = 1; i < list.length; i++) {
                    tempAttacks.add(list[i]);
                }
                System.out.println("placing " + list[0]);
                allNPCs.get(list[0]).setAttacks(tempAttacks);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }

        // items
        allItems = new HashMap<>();
        filepath = path + "ItemData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            String[] list;
            while ((line = sc.readLine()) != null) {
                list = line.split(",");
                allItems.put(list[0], new Item(list));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }

        // locations
        allLocations = new ArrayList<>();
        filepath = path + "LocationData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            String[] list;
            while ((line = sc.readLine()) != null) {
                list = line.split(",");
                allLocations.add(new Location(list));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }
    }

    private static void fightEnemy(Player player, NPC enemy, HashMap<String, Attack> allAttacks,
            Scanner console, Random rand) throws IOException {
        int enemyHealth = enemy.getHealthPoints();
        System.out.println("\tA " + enemy.getName() + " has appeared!\n");        

        while(enemyHealth > 0) {
            //todo create private helpermethod that prints stats
            System.out.println("\nYour HP: " + player.getHealthPoints());
            System.out.println(enemy.getName() + "'s HP: " + enemyHealth);
            System.out.println("\nWhat will you do?");
            System.out.println("\n\t1. Attack");
            System.out.println("\n\t2. Use Item");
            System.out.println("\n\t3. Study"); 

            int option = Integer.parseInt(console.nextLine());
            // validate
            System.out.println();
            switch (option) {
            case 1:
                // attack
                System.out.println("\nWhat attack will you use?");
                ArrayList<String> playerAttackNames = player.getAttackNames();
                for (int i = 0; i < playerAttackNames.size(); i++) {
                    String atkName = playerAttackNames.get(i);
                    System.out.printf("\t%d. %s (%d MP)\n\t%s\n", i, atkName, 
                            allAttacks.get(atkName).getManaCost(), allAttacks.get(atkName).getDescription());
                }
                option = Integer.parseInt(console.nextLine());
                // validate
                player.attack(player, allAttacks.get(playerAttackNames.get(option)), enemy);
                enemy.attack(enemy, allAttacks.get(enemy.getRandomAttackName()), player);
                break;

            case 2:
                // use item
                // player.useItem(enemy, console);
                break;
            case 3:
                //Leave
                enemyHealth = -420;
                break;
            case 4:
                //Just in case
                //maybe for special drops? Wha

                break;
            default:
                break;
            }
        }

        if (enemyHealth == -420){
            System.out.println();
            System.out.println("You have fled the " + enemy.getName() + "! L weak");
        } else {
            System.out.println();
            System.out.println("You have defeated " + enemy.getName() + "!");
            player.updateMoney(5);
            //System.out.println("You now have + " player.getMoney() + " monies!");
            if (rand.nextInt(100) > 90){
                System.out.println("You leveled up! Your new level is: " + player.getLVL());
            }
        }
        console.close();
    }

}