package Equipement.Shields;

import Equipement.DefensiveEquipement;

public abstract class Shield extends DefensiveEquipement {
    protected int defenseBonus;
    protected int lvl;
    protected String emoji;

    public Shield(String name ,String type) {
        super(name, type);
        this.type = type;
    }

    public int getDefenseBonus() {return defenseBonus;}
    public int getLvl() {return lvl;}
    public String getEmoji() {return emoji;}

    public void setDefenseBonus(int defenseBonus) {this.defenseBonus = defenseBonus;}
    public void setLvl(int lvl) {this.lvl = lvl;}
}
