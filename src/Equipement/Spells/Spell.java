package Equipement.Spells;

import Equipement.OffensiveEquipment;

public abstract class Spell extends OffensiveEquipment {
    String type;
    protected int powerBonus;
    protected int lvl;

    public Spell(String name, String type) {
        super(name, type);
        this.type = type;
    }

    public int getPowerBonus() {return powerBonus;}
    public int getLvl() {return lvl;}

    public void setPowerBonus(int powerBonus) {this.powerBonus = powerBonus;}
    public void setLvl(int lvl) {this.lvl = lvl;}
}
