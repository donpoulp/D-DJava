package Equipement.Philters;

import Equipement.DefensiveEquipement;

public abstract class Philter extends DefensiveEquipement {
    protected int LifePoint;
    protected int lvl;
    protected String emoji;

    public Philter(String name ,String type) {
        super(name, type);
        this.type = type;
    }

    public int getLifePoint() {return LifePoint;}
    public int getLvl() {return lvl;}
    public String getEmoji() {return emoji;}

    public void setLvl(int lvl) {this.lvl = lvl;}
    public void setLifePoint(int lifePoint) {this.LifePoint = lifePoint;}

    @Override
    public String toString() {
        return "Philter{" +
                "type='" + type + '\'' +
                ", LifePoint=" + LifePoint +
                ", lvl=" + lvl +
                '}';
    }
}
