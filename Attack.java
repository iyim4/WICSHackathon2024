public class Attack {
    private String name;
    private int damage;
    private int manaCost;
    private String description;


    public Attack(String name, int damage, int manaCost, String description){
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.description = description;
    }

    // constructor for file reader. must be in order: name, damage, manaCost, description
    public Attack(String[] args){
        this.name = args[0];
        this.damage = Integer.parseInt(args[1]);
        this.manaCost = Integer.parseInt(args[2]);
        this.description = args[3];
    }

    public void printDescription() {
            System.out.println(description);
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getDescription() {
        return description;
    }

   
}
