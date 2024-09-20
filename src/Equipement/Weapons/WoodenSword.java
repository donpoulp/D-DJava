package Equipement.Weapons;

public class WoodenSword extends Weapon{

    int powerBonus;
    int lvl;

    /// constructor ///
    public WoodenSword(String name) {
        super(name, "WoodenSword");
        this.powerBonus = 1;
        this.lvl = 1;
    }

    /// getter ///
    public int getPowerBonus() {return this.powerBonus;}
    public int getLvl() {return this.lvl;}

    /// setters ///
    public void setPowerBonus(int powerBonus) {this.powerBonus = powerBonus;}
    public void setLvl(int lvl) {this.lvl = lvl;}

    /// toString ///
    @Override
    public String toString() {
        return "WoodenSword{" +
                ", name = " + this.getName() +
                ", powerBonus = " + powerBonus +
                ", lvl =  " + lvl +
                '}';
    }
}
