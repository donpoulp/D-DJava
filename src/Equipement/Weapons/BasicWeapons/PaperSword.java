package Equipement.Weapons.BasicWeapons;

import Equipement.Weapons.Weapon;
import Personnage.Inventory.Items;

public class PaperSword extends Weapon implements Items {

    /// constructor ///
    public PaperSword() {
        super("PaperSword", "Sword");
        this.powerBonus = 1;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F58D);
    }

    /// getter ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Epée en Papier : {" +
                " puissance bonus = " + powerBonus +
                " , lvl = " + lvl +
                " }";
    }
}
