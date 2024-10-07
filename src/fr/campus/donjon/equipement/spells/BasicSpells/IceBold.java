package fr.campus.donjon.equipement.spells.BasicSpells;

import fr.campus.donjon.equipement.spells.Spell;
import fr.campus.donjon.personnage.inventory.Items;

public class IceBold extends Spell {

    /// contructor ///
    public IceBold() {
        super("IceBold", "Spell");
        this.powerBonus = 2;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F9CA);
    }
    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Boule de Glace : {" +
                " puissance bonus = " + powerBonus +
                " , lvl = " + lvl +
                " }";
    }
}
