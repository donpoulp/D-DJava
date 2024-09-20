package Equipement.Shields;

public class WoodenShield extends Shield {
    int defenseBonus;
    int lvl;

    /// constructor ///
    public WoodenShield(String name) {
        super(name, "Bouclier en bois");
        this.defenseBonus = 5;
        this.lvl = 1;
    }

    /// getters ///
    public int getDefenseBonus() {return defenseBonus;}
    public int getLvl() {return lvl;}

    /// setters ///
    public void setDefenseBonus(int defenseBonus) {this.defenseBonus = defenseBonus;}
    public void setLvl(int lvl) {this.lvl = lvl;}

    /// tostring ///
    @Override
    public String toString() {
        return "WoodenShield{" +
                ", name = " + this.getName() +
                ", defenseBonus = " + defenseBonus +
                ", lvl = " + lvl +
                '}';
    }
}
