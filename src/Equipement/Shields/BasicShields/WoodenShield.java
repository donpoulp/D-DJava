package Equipement.Shields.BasicShields;

import Equipement.Shields.Shield;

public class WoodenShield extends Shield {

    /// constructor ///
    public WoodenShield() {
        super("WoodenShield", "Shield");
        this.defenseBonus = 5;
        this.lvl = 1;
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return "WoodenShield{" +
                ", name = " + this.getName() +
                ", defenseBonus = " + defenseBonus +
                ", lvl = " + lvl +
                '}';
    }
}
