import java.util.HashMap;

public class ItemShop {
    HashMap<String, Item> items = new HashMap<>();

    // functions to buy and sell items

    // // constructor
    // public ItemShop() throws IOException{
    //     items = new Hashmap<>();
    //     readFile();
    // }
    

    // // looks at ItemData.csv, takes each line, and shoves it in the items arraylist
    // private static void readFile() throws IOException{
    //     String file = "itemData.csv";
    //     try(BufferedReader sc = new BufferedReader(new FileReader(file))) {
    //         String line = "";
    //         while ((line = sc.readLine()) != null) {
    //             items.add(line.split(","));
    //         }
    //     } catch (FileNotFoundException e) {
    //         System.out.println("Where is the file dude. YOU HAD ONE JOB");
    //     }
    // }   
}