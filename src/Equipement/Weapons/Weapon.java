package Equipement.Weapons;

import Equipement.OffensiveEquipment;

public abstract class Weapon extends OffensiveEquipment {
    String type;

    /// contructor ///
    public Weapon(String name, String type) {
        super(name, type);
        this.type = type;
    }
    /// getters ///

    /// setters ///

    /// toString ///
}
