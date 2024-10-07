package fr.campus.donjon.equipement.weapons.BasicWeapons;

import fr.campus.donjon.equipement.weapons.Weapon;
import fr.campus.donjon.personnage.inventory.Items;

public class WoodenSword extends Weapon {

    /// constructor ///
    public WoodenSword() {
        super("WoodenSword", "Sword");
        this.powerBonus = 1;
        this.lvl = 1;
        this.emoji = Character.toString(0x1FA9A);
    }

    /// getter ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Epée en bois : {" +
                " puissance bonus = " + powerBonus +
                " , lvl = " + lvl +
                " }";
    }
}
