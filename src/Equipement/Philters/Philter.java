package Equipement.Philters;

import Equipement.DefensiveEquipement;

public abstract class Philter extends DefensiveEquipement {
    String type;
    protected int LifePoint;
    protected int lvl;

    public Philter(String name ,String type) {
        super(name, type);
        this.type = type;
    }

    public int getLifePoint() {return LifePoint;}
    public int getLvl() {return lvl;}

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
