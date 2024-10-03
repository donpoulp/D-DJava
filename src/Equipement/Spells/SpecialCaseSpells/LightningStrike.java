package Equipement.Spells.SpecialCaseSpells;

import Equipement.Spells.Spell;
import GameRule.Board.Case;
import Personnage.Inventory.Items;

public class LightningStrike extends Spell implements Case, Items {

    /// constructor ///
    public LightningStrike() {
        super("LightningStrike","Spell");
        this.powerBonus = 7;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F329);
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Chaine d'éclair : {" +
                " puissance bonus = " + powerBonus +
                " , lvl = " + lvl +
                " }";
    }
}
