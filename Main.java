
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
            // welcome message
        System.out.println("Welcome, young aspiring CS transfer student! You were thrown out by your parents," + 
        "but do not fear you shall go into debt and achieve your CS degree (hopefully). ! : ( )");

        // enemy creation (??)
        // later todo create a method that takes in datafile(.csv) and arraylist
        HashMap<String, NPC> enemies = new HashMap<>();
        Attack homework = new Attack("Homework", 6, 1, "The student's bane");
        Attack slap = new Attack("Slap", 3, 0, "Who can't slap?");
        enemies.put("Student", new NPC("Student", new ArrayList<Attack>(){{add(homework);}}, 10, 10, 10));
        enemies.put("TA", new NPC("TA", new ArrayList<Attack>(){{add(homework);}}, 20, 20, 20));
        enemies.put("Professor", new NPC("Professor", new ArrayList<Attack>(){{add(homework);}}, 30, 30, 30));
        enemies.put("Janitor", new NPC("Janitor", new ArrayList<Attack>(){{add(homework);}}, 10, 10, 10) );

        // player input --> name selection
        System.out.println("\nWhat is your name? You poor innocent soul.");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        Player player = new Player(name, new ArrayList<Attack>(), 10, 10, 10);
        System.out.println("So your name is " + name + "?");
        
        // some setup
        ArrayList<Location> locations = new ArrayList<>();
        Random rand = new Random();
        //readFile(locations);
        
        System.out.println("You must venture "); //todo
        int option = 0;
        while (option != -1) {
            // print menu (& stats?)
            // print location options
            System.out.println("\nWhat will you do?\n");
            for (int i = 1; i <= locations.size(); i++) {
                System.out.printf("\t%d. Go to the %s.\n", i, locations.get(i - 1).getName());
            }
            System.out.printf("\t%d. Go to the Item Shop.\n\n", locations.size());
            
            // get player option
            option = Integer.parseInt(console.nextLine());
            while (option < -1 && option > locations.size()) {
                System.out.println("Please enter a number between 0 and " + locations.size() + ", or -1 to quit.");
                option = Integer.parseInt(console.nextLine());
            }

            // update
            if (option == locations.size()) {
                // open shop dialogue <-- wait like item shop or??? Lorena
                System.out.println("Welcome to the shop! Where one and all can buy to their " +
                "hearts content, what would you like?");
                // use itemShop class 
            } else {
                Location loc = locations.get(option);
                loc.printDescription();
                // get enemy from location (for weighted spawn distribution)
                // call fightEnemy
                fightEnemy(player, enemies.get("Janitor"));
            }
        }
        if (option == -1) {
            // quit message
        } else {
            System.out.println("You win ig that's cool for you");
        }
        console.close();
    }

    private static void readFile() throws IOException{
        String path = "./data/";
        // parallel arrays: stores the file name and the number of arguments per line
        String[] dataFiles = {
            "AttackData.csv",
            "NPCData.csv",
            "ItemData.csv",
            "LocationData.csv"
        };

        ArrayList<Attack> attacks = new ArrayList<>();
        String filepath = path + "AttackData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            while ((line = sc.readLine()) != null) {
                attacks.add(new Attack(line.split(",")));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }

        ArrayList<NPC> NPCs = new ArrayList<>();
        filepath = path + "NPCData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            while ((line = sc.readLine()) != null) {
                NPCs.add(new NPC(line.split(",")));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }

        ArrayList<Item> items = new ArrayList<>();
        filepath = path + "AttackData.csv";
        try(BufferedReader sc = new BufferedReader(new FileReader(filepath))) {
            String line = "";
            while ((line = sc.readLine()) != null) {
                items.add(new dataItem(line.split(",")));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Where is the file dude. YOU HAD ONE JOB");
        }

        // for (int i = 0; i < dataFiles.length; i++) {
        //     String filePath = path + dataFiles[i];
        //     int numDataPerLine = dataPerLine[i];
        //     fillArrayList(scanner, filePath, numDataPerLine);
        // }


        // String file = "LocationData.csv";
        // try(BufferedReader sc = new BufferedReader(new FileReader(file))) {
        //     String line = "";
        //     while ((line = sc.readLine()) != null) {
        //         //locations.add(line.split(","));
        //     }
        // } catch (FileNotFoundException e) {
        //     System.out.println("Where is the file dude. YOU HAD ONE JOB");
        // }
    } 

    private static void fillArray(Scanner scanner){
        //what are we filling the array with? - Lorena
    }
    
    private static void fightEnemy(Player player, NPC enemy) throws IOException{
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
        int enemyHealth = enemy.getHealthPoints();
        System.out.println("\tA " + enemy.getName() + " has appeared!\n");        
        
        while(enemyHealth > 0){
          System.out.println("\nYour HP: " + player.getHealthPoints());
          System.out.println(enemy.getName() + "'s HP: " + enemyHealth);
          System.out.println("\nWhat will you do?");
          System.out.println("\n\t1. Attack");
          System.out.println("\n\t2. Use Item");
          System.out.println("\n\t3. Study");
        
          int option = Integer.parseInt(console.nextLine());
          System.out.println();
          switch (option) {
            case 1:
                System.out.println("\nWhat attack will you use?");
                for (int i = 1; i < 5; i++){
                    System.out.println("\n\t1. " + player.getAttack(i).getName());
                }
                option = Integer.parseInt(console.nextLine());
                player.attack(player, player.getAttack(option), enemy);
                enemy.attack(enemy, enemy.getAttack(rand.nextInt(enemy.getAttacks().size())), player);
                break;

            case 2:
                // Item
                System.out.println("Welcome to the item shop. Can you even afford anything?");
                ItemShop shop = new ItemShop();
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
            player.incMoney(5);
            //System.out.println("You now have + " player.getMoney() + " monies!");
            if (rand.nextInt(100) > 90){
                System.out.println("You leveled up! Your new level is: " + player.getLVL());
            }
        }
        console.close();
      }
      
    }
    


