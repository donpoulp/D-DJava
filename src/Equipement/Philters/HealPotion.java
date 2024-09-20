package Equipement.Philters;

public class HealPotion extends Philter {
    int defenseBonus;
    int lvl;

    /// constructor ///
    public HealPotion(String name) {
        super(name, "healing potion");
        this.defenseBonus = 1;
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
        return "HealPotion{" +
                ", name = " + this.getName() +
                ", defenseBonus = " + defenseBonus +
                ", lvl = " + lvl +
                '}';
    }
}
