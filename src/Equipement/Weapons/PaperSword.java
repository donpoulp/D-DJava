package Equipement.Weapons;

public class PaperSword extends Weapon{

    int powerBonus;
    int lvl;

    /// constructor ///
    public PaperSword(String name) {
        super(name, "PaperSword");
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
        return "PaperSword{" +
                ", name = " + this.getName() +
                ", powerBonus = " + powerBonus +
                ", lvl =  " + lvl +
                '}';
    }
}
