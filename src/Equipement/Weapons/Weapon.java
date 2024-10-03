package Equipement.Weapons;

import Equipement.OffensiveEquipment;

public abstract class Weapon extends OffensiveEquipment {
    protected int powerBonus;
    protected int lvl;
    protected String emoji;;

    /// contructor ///
    public Weapon(String name, String type) {
        super(name, type);
        this.type = type;
    }
    /// getters ///
    public int getPowerBonus() {return this.powerBonus;}
    public int getLvl() {return this.lvl;}
    public String getEmoji() {return emoji;}

    /// setters ///
    public void setPowerBonus(int powerBonus) {this.powerBonus = powerBonus;}
    public void setLvl(int lvl) {this.lvl = lvl;}

    /// toString ///
}
