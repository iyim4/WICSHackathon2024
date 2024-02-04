
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// import java.util.StringBuilder;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // welcome message
        System.out.println("Welcome, young aspiring CS transfer student! You were thrown out by your parents," + 
                "but do not fear you shall go into debt and achieve your CS degree (hopefully). ! : ( )");

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

        System.out.println("You must venture outside!"); //todo
        int option = -1;
        while (option != 0) {
            // print location options
            System.out.println("\nWhat will you do?\n");
            System.out.printf("\t0. Quit\n");
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
                shop.runShop(player);
            } else {
                Location loc = allLocations.get(option);
                loc.printDescription();
                // get enemy from location (for weighted spawn distribution)
                // call fightEnemy
                fightEnemy(player, loc.getRandomLocalNPC(allNPCs), allAttacks, console, rand);
            // }
            }
        if (option == 0) {
            System.out.println("Quitting...");
        } else {
            System.out.println("You win ig that's cool for you");
        }
        console.close();
        }
    }

    // read in data from all files and stores it in allAttacks, allNPCs, allItems, and allLocations
    private static void readData(HashMap<String, Attack> allAttacks, HashMap<String, NPC> allNPCs,
            HashMap<String, Item> allItems, ArrayList<Location> allLocations) throws IOException{
        String path = "./data/";

        // attacks
        // allAttacks = new HashMap<>();
        String filepath = path + "AttackData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            String[] list;
            while ((line = sc.readLine()) != null) {
                list = line.split(",");
                //System.out.println("creating attack " + toStringArray(list));
                allAttacks.put(list[0], new Attack(list));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }

        // NPCs
        // allNPCs = new HashMap<>();
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
        
        // //debugging, delete later
        // System.out.println("now npcs are:");
        // for (String a : allNPCs.keySet()) {
        //     System.out.print(a + ", ");
        
        // System.out.println("DEBUGGING: value of \"Mike Scott\" " + allNPCs.get("Mike Scott"));
        // System.out.println("DEBUGGING: value of \"Carol Ramsey\" " + allNPCs.get("Carol Ramsey"));
        // System.out.println();

        // for (NPC n : allNPCs) {
        //     System.out.println(NPC.getName() + ", ");
        // }

        // NPCs' attacks
        filepath = path + "NPCAttackData.csv";
        try(BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("yourfile"), "UTF-8"))) {
            sc.mark(1);
            if (sc.read() != 0xFEFF){
                sc.reset();
            }
            //BufferedReader sc = new BufferedReader(new FileReader(filepath)) OLD
            //BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream("yourfile"), "UTF-8")) NEW
            String line = "";
            String[] list;
            while ((line = sc.readLine()) != null) {
                list = line.split(",");
                ArrayList<String> tempAttacks = new ArrayList<>();
                for (int i = 1; i < list.length; i++) {
                    tempAttacks.add(list[i]);
                }
               
                NPC temp = allNPCs.get(list[0]);
                // System.out.println("DEBUG: list[0]" + list[0]);
                //  System.out.println(list[0] + " " + temp);
                if (temp != null) {
                    temp.setAttacks(tempAttacks);
                } else {
                    // delete later
                    System.out.println("failed to place " + toStringArray(list));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }

        // items
        // allItems = new HashMap<>();
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
        // allLocations = new ArrayList<>();
        filepath = path + "LocationData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            String[] list;
            while ((line = sc.readLine()) != null) {
                list = line.split(",");
                Location l = new Location(list);
                // System.out.println("loc " + toStringArray(list));
                // System.out.println(l.getName());
                allLocations.add(l);
                // System.out.println("DEBUG: allLocations newly added: " + allLocations.get(allLocations.size()-1).getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }
        allLocations.remove(0);
    }

    private static String toStringArray(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(", ");
        }
        return sb.toString();
    }

    private static void fightEnemy(Player player, NPC enemy, HashMap<String, Attack> allAttacks,
            Scanner console, Random rand) throws IOException {
        int enemyHealth = enemy.getHealthPoints();
        System.out.println("\tA " + enemy.getName() + " has appeared!\n");  
        //System.out.println(player.printStats(enemy));      

        while(enemyHealth > 0) {
            //todo create private helpermethod that prints stats
            System.out.println("\nYour HP: " + player.getHealthPoints());
            System.out.println(enemy.getName() + "'s HP: " + enemyHealth);
            System.out.println("\nWhat will you do?");
            System.out.println("\n\t1. Attack");
            System.out.println("\n\t2. Use Item");
            System.out.println("\n\t3. Study (Flee)"); 

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
                player.chooseItem(enemy, console);
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
            if (enemy.isProfessor()){
                player.updateMoney(40);
            }
            player.updateMoney(10);
            //System.out.println("You now have + " player.getMoney() + " monies!");
            if (rand.nextInt(100) > 90){
                System.out.println("You leveled up! Your new level is: " + player.getLVL());
            }
        }
        console.close();
    }

}