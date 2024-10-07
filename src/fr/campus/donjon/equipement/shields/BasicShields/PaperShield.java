package fr.campus.donjon.equipement.shields.BasicShields;

import fr.campus.donjon.equipement.shields.Shield;
import fr.campus.donjon.personnage.inventory.Items;

public class PaperShield extends Shield {

    /// constructor ///
    public PaperShield() {
        super("PaperShield", "Shield");
        this.defenseBonus = 1;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F9FB);
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return emoji + " Bouclier de papier : {" +
                " defenseBonus = " + defenseBonus +
                " , lvl = " + lvl +
                " }";
    }
}
