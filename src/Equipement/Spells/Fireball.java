package Equipement.Spells;

public class Fireball extends Spell {
    int powerBonus;
    int lvl;

    /// contructor ///
    public Fireball(String name) {
        super(name, "fireball");
        this.powerBonus = 2;
        this.lvl = 1;
    }
    /// getters ///
    public int getPowerBonus() {return powerBonus;}
    public int getLvl() {return lvl;}

    /// setters ///
    public void setPowerBonus(int powerBonus) {this.powerBonus = powerBonus;}
    public void setLvl(int lvl) {this.lvl = lvl;}

    /// toString ///
    @Override
    public String toString() {
        return "Fireball{" +
                ", name = " + this.getName() +
                ", powerBonus = " + powerBonus +
                ", lvl = " + lvl +
                '}';
    }
}
