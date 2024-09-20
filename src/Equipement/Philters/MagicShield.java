package Equipement.Philters;

public class MagicShield extends Philter {
    int defenseBonus;
    int lvl;

    /// constructor ///
    public MagicShield(String name) {
        super(name, "MagicShield");
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
        return "MagicShield{" +
                ", name = " + this.getName() +
                ", defenseBonus = " + defenseBonus +
                ", lvl = " + lvl +
                '}';
    }
}
