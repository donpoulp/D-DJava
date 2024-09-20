package Equipement.Shields;

import Equipement.DefensiveEquipement;

public abstract class Shield extends DefensiveEquipement {
    String type;

    public Shield(String name ,String type) {
        super(name, type);
        this.type = type;
    }

}
