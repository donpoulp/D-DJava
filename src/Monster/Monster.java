package Monster;

public abstract class Monster {
    String name;
    String type;
    protected int attackDommage;
    protected int health;
    protected String emoji;
    //int health;

    /// constructor ///
    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /// getters ///
    public String getName() {return name;}
    public String getType() {return type;}
    public int getAttackDommage() {return attackDommage;}
    public int getHealth() {return health;}
    public String getEmoji() {return emoji;}
    //public static int getHealth() {return health;}

    /// setters ///
    public void setName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}
    public void setAttackDommage(int attackDommage) {this.attackDommage = attackDommage;}
    public void setHealth(int health) {this.health = health;}

    //public static void setHealth(int health) {this.health = health;}


    /// toString ///
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
