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
