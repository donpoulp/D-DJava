package fr.campus.donjon.equipement.spells.SpecialCaseSpells;

import fr.campus.donjon.equipement.spells.Spell;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.inventory.Items;

public class SupremeFireBall extends Spell {

    /// constructor ///
    public SupremeFireBall() {
        super("SupremeFireBall","Spell");
        this.powerBonus = 7;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F525);
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Boule de feu Suprème : {" +
                " puissance bonus = " + powerBonus +
                " , lvl = " + lvl +
                " }";
    }
}
