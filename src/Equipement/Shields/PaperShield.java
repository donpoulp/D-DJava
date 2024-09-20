package Equipement.Shields;

public class PaperShield extends Shield {
    int defenseBonus;
    int lvl;

    /// constructor ///
    public PaperShield(String name) {
        super(name, "PaperShield");
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
        return "PaperShield{" +
                ", name = " + this.getName() +
                ", defenseBonus = " + defenseBonus +
                ", lvl = " + lvl +
                '}';
    }
}
