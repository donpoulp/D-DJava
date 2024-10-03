package Equipement.Spells.BasicSpells;

import Equipement.Spells.Spell;
import Personnage.Inventory.Items;

public class IceBold extends Spell implements Items {

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
