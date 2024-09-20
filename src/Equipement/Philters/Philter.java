package Equipement.Philters;

import Equipement.DefensiveEquipement;

public abstract class Philter extends DefensiveEquipement {
    String type;

    public Philter(String name ,String type) {
        super(name, type);
        this.type = type;
    }

}
