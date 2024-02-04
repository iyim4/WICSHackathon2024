import java.util.Scanner;
import java.util.Random;
import java.util.TreeMap;

public class ItemShop {
    TreeMap<String, Item> items = new TreeMap<>();
    String[] introductions = {"Welcome to the shop! Where one and all can buy to their " +
                "hearts content, what would you like?", "Welcome to the item shop. Can you even afford anything?",
                "yeah, um, I guess you like, um, buy stuff?","Scram loser, unless you got some cash to pay for items, "
                 + "there's a hefty price!"};
    Random random = new Random();
    //item.put()
    //item.put(key, item)

    // functions to buy and sell items

    public void runShop(Player player) {
        Scanner console = new Scanner(System.in);
        System.out.println(introductions[random.nextInt(4)]);
        // System.out.println("");
        // print options
        int option = -1;
        while (option != 0) {
            System.out.println("0. Leave shop\n1. Buy Items\n2. Sell Items");
            option = Integer.parseInt(console.nextLine());
            // validate
            if (option == 1) {
                buyItem(player, console);
            } else if (option == 2) {
                sellItem(player, console);
            } else {
                // place validation in here?
            }
        }
        console.close();

    }

    public void buyItem(Player player, Scanner console) {
        System.out.println("What would you like to buy? You have $" + player.getMoney());
        int option = -1;
        while (option != 0) {
            System.out.println("0. Go back");
            // print options
            int i = 1;
            for (String name : items.keySet()) {
                System.out.printf("\t%d. %s: $%d, %s\n", i++, name, items.get(name).getPrice(), items.get(name).getDescription());
            }

            option = Integer.parseInt(console.nextLine());
            // validate
            if (option != 0) {
                Item chosenItem = getItemAtPosition(option - 1);
                if (chosenItem.getPrice() > player.getMoney()) {
                    System.out.println("You don't have enough money. Imagine being BROKE HAHAHAHAH"); // insert funny dialogue?
                } else {
                    player.updateMoney(-1 * chosenItem.getPrice());
                    player.addItem(chosenItem);
                    System.out.printf("You bought %s and have %d left.\n ", chosenItem.getName(), player.getMoney());
                }
            }
        }
    }

    /**
     * private helper to get item at an index, (inefficient O(N) change??)
     * pre: 0 <= pos <= items.size()
     */
    private Item getItemAtPosition(int pos) {
        int i = 0;
        for (String name : items.keySet()) {
            if (i == pos) {
                return items.get(name);
            }
            i++;
        }
        // should never reach here
        return null;
    }

    public void sellItem(Player player, Scanner console) {
        // special case: empty inventory
        if (player.getInventory().size() == 0) {
            System.out.println("You have nothing to sell.");
            return;
        }

        System.out.println("What would you like to sell? you have $" + player.getMoney());
        int option = -1;
        while (option != 0) {
            System.out.println("0. Go back");
            // print options
            int i = 1;
            for (Item item : player.getInventory()) {
                System.out.printf("\t%d. %s: $%d, %s\n", i++, item.getName(), item.getPrice(), item.getDescription());
            }

            option = Integer.parseInt(console.nextLine());
            // validate
            if (option != 0) {
                Item chosenItem = player.getInventory().get(option - 1);
                player.updateMoney(chosenItem.getPrice());
                player.getInventory().remove(option - 1);
                System.out.printf("You sold %s for $%d.\n", chosenItem, chosenItem.getPrice());
            }
        }
    }
}