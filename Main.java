
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            // welcome message
        System.out.println("Welcome, young aspiring CS transfer student! You were thrown out by your parents," + 
        "but do not fear you shall go into debt and achieve your CS degree (hopefully). ! : ( )");

        // enemy creation (??)
        // later todo create a method that takes in datafile(.csv) and arraylist
        HashMap<String, NPC> enemies = new HashMap<>();
        enemies.put("Student", new NPC("Student", 10, 10, 10));
        enemies.put("TA", new NPC("TA", 20, 20, 20));
        enemies.put("Professor", new NPC("Professor", 30, 30, 30));
        enemies.put("Janitor", new NPC("Janitor", 30, 10, 5) );

        // player input --> name selection
        System.out.println("\nWhat is your name? You poor innocent soul.");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        Player player = new Player(name);
        System.out.println("So your name is " + name + "?");
        ArrayList<Location> locations = new ArrayList<>();

        System.out.println("You must venture ")
        boolean running = true;
        while (running) {
            Random rand = new Random();

            // player input
            int option = Integer.parseInt(console.nextLine());

            // print menu
            // print options
            System.out.println("\nWhat will you do?");
            for (int i = 1; i <= locations.length(); i++)
            System.out.println("\n\t1. Go into classroom");
            System.out.println("\n\t2. Go to the art building");
            System.out.println("\n\t3. Go to the GDC");
            System.out.println("\n\t4. Go to the item shop.");
            System.out.println();
            
            // get input
            // update
            switch (option) {
            case 1:
                // classroom
                update(player, enemies.get(rand.nextInt(enemies.size())), 1);

                break;
            case 2:
                // art

                break;
            case 3:
                //gdc

                break;
            case 4:
                //item shop

                break;
            default:
                break;
            }
        }
        System.out.println("You win ig that's cool for you");
        console.close();
    }
    

    // pre: validate option
    private static void update(Player player, NPC enemy, int option) {
        Attack attack = player.getAttack(option);
        player.attack(attack, enemy);
    }

    private static void fightEnemy(Player player, NPC enemy){
        int enemyHealth = enemy.getHealthPoints();
        System.out.println("\tA " + enemy.getName() + " has appeared!\n");
        
        while(enemyHealth > 0){
          System.out.println("\nYour HP: " + Player.getHealthPoints());
          System.out.println(enemy.getName() + "'s HP: " + enemyHealth);
          System.out.println("\nWhat will you do?");
          System.out.println("\n\t1. Attack");
          System.out.println("\n\t2. Use Item");
          System.out.println("\n\t3. Study");
        
          String input = console.nextLine();
          System.out.println();
          if (input.equals("1")){
            //Attac
            
          } else if (input.equals("2")) {
            //Item moment
            
          } else if (input.equals("3")) {
            /
            
          } else if (input.equals("4")) {
            if (food > 0){
            System.out.println("You have healed yourself!\nYou are now fat and lazy but not tired or hungry!");
              int damageTaken = rand.nextInt(enemyAttackDamage);
              System.out.println("You have gained " + 50 + " health!");
              food -= 1;
              health += 50;
            } else {
              System.out.println("Sorry! You have no food");
            }
            int damageTaken = rand.nextInt(enemyAttackDamage);
            System.out.println("You have taken " + damageTaken + " damage!");
            
            health -= damageTaken;
            
          } else if (input.equals("5")) {
            System.out.println("You have used your spamming thunderbolt attack!");
            int damageDealt = rand.nextInt(attackDamage);
            int damageTaken = rand.nextInt(enemyAttackDamage);
  
            enemyHealth -= 2 * damageDealt;
            health -= damageTaken;
            System.out.println("You have dealt " + damageDealt + " damage!");
            System.out.println("You have taken " + damageTaken + " damage!");
            
          }
  
        }
        System.out.println();
        System.out.println("You have defeated " + thing + "!");
        int tempMoney = Math.abs(rand.nextInt(10));
        System.out.println("You have gained " + tempMoney + " dollars!");
        System.out.println();
        money += tempMoney;
        Depression = false;
        attackDamage = trueAttackDamage;
      }
    }
    
}


