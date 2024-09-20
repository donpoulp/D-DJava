package Equipement.Spells;

import Equipement.OffensiveEquipment;

public abstract class Spell extends OffensiveEquipment {
    String type;

    public Spell(String name, String type) {
        super(name, type);
        this.type = type;
    }
}
