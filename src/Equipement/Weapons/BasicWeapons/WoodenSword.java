package Equipement.Weapons.BasicWeapons;

import Equipement.Weapons.Weapon;

public class WoodenSword extends Weapon {

    /// constructor ///
    public WoodenSword() {
        super("WoodenSword", "Sword");
        this.powerBonus = 1;
        this.lvl = 1;
    }

    /// getter ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "WoodenSword{" +
                ", name = " + this.getName() +
                ", powerBonus = " + powerBonus +
                ", lvl =  " + lvl +
                '}';
    }
}
