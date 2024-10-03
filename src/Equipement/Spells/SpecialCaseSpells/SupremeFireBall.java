package Equipement.Spells.SpecialCaseSpells;

import Equipement.Spells.Spell;
import GameRule.Board.Case;
import Personnage.Inventory.Items;

public class SupremeFireBall extends Spell implements Case, Items {

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
