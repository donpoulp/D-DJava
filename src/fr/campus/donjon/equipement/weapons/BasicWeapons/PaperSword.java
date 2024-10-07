package fr.campus.donjon.equipement.weapons.BasicWeapons;

import fr.campus.donjon.equipement.weapons.Weapon;
import fr.campus.donjon.personnage.inventory.Items;

public class PaperSword extends Weapon {

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
