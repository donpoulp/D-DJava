package fr.campus.donjon.equipement.spells.SpecialCaseSpells;

import fr.campus.donjon.equipement.spells.Spell;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.inventory.Items;

public class LightningStrike extends Spell {

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
