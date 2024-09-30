package Personnage;

public abstract class Personnage {

    String name;
    String type;
    int health;
    int attackForce;

    /// constructeur ///
    public Personnage(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public Personnage(String name) {
        this.name = name;
    }

    public Personnage() {

    }

    /// getter ///
    public String getName() {return name;}
    public String getType() {return type;}
    public int getHealth(){return this.health;}
    public int getAttackForce(){return this.attackForce;}



    /// setter ///
    public void setName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}
    public void setHealth(int health){this.health = health;}
    public void setAttackForce(int attackForce){this.attackForce = attackForce;}

    @Override
    public String toString() {
        return "Personnage{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", health=" + health +
                ", attackForce=" + attackForce +
                '}';
    }
}