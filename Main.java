import java.util.*;

public class Main {
    public static void main(String[] args) {
            // welcome message
        System.out.println("Welcome young aspring CS Major. You were thrown out by your parents," + 
        "but do not fear you shall go into debt and acheive your degree (hopefully). ! : ( )");

        // enemy creation (??)
        HashMap<String, NPC> enemies = new HashMap<>();
        enemies.put("Student", new NPC("Student", 10, 10, 10));
        enemies.put("TA", new NPC("TA", 20, 20, 20));
        enemies.put("Professor", new NPC("Professor", 30, 30, 30));

        // player input
        Scanner console = new Scanner(System.in);
        int option = Integer.parseInt(console.nextLine());
        boolean running = true;
        while (true) {
            // print menu
            // print options
            System.out.println("\nWhat will you do?");
            System.out.println("\n\t1. Go into classroom");
            System.out.println("\n\t2. ");
            System.out.println("\n\t3. ");
            System.out.println("\n\t4. ");
            System.out.println();
            // get input
            // update
        }
    }
    

    // 
    private void update(Player player, NPC enemy, int option) {
        



        switch (option) {
            case 1:
                // damage enemy
                player, enemy.attacks.get(input));
                break;
            case 2:
                break;
            default:
                break;
        }

        // enemy damages player
    }

    // pre: attacker has enough mp
    private void damage(Char target, Char attacker, Attack atk) {
        // attacker's mp reduces, 
        // target's hp reduces,
    }

    
}


