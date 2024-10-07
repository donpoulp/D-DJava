package fr.campus.donjon.equipement.shields.BasicShields;

import fr.campus.donjon.equipement.shields.Shield;
import fr.campus.donjon.personnage.inventory.Items;

public class WoodenShield extends Shield {

    /// constructor ///
    public WoodenShield() {
        super("WoodenShield", "Shield");
        this.defenseBonus = 1;
        this.lvl = 1;
        this.emoji = Character.toString(0x1FAB5);
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return emoji + " Bouclier en bois : {" +
                " defenseBonus = " + defenseBonus +
                " , lvl = " + lvl +
                " }";
    }
}
