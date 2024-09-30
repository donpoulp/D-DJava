package Equipement.Weapons.BasicWeapons;

import Equipement.Weapons.Weapon;

public class PaperSword extends Weapon {

    /// constructor ///
    public PaperSword() {
        super("PaperSword", "Sword");
        this.powerBonus = 1;
        this.lvl = 1;
    }

    /// getter ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "PaperSword{" +
                ", name = " + this.getName() +
                ", powerBonus = " + powerBonus +
                ", lvl =  " + lvl +
                '}';
    }
}
