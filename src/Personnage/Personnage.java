package Personnage;

import Personnage.Inventory.Inventory;

public abstract class Personnage {

    String name;
    String type;
    int maxHealth;
    int health;
    int attackForce;
    Inventory inventory;

    /// constructeur ///
    public Personnage(String name, String type) {
        this.name = name;
        this.type = type;
        this.inventory = new Inventory(10);
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
    public int getMaxHealth() {return maxHealth;}
    public Inventory getInventory() {return inventory;}

    /// setter ///
    public void setName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}
    public void setHealth(int health){this.health = health;}
    public void setAttackForce(int attackForce){this.attackForce = attackForce;}
    public void setInventory(Inventory inventory) {this.inventory = inventory;}

}