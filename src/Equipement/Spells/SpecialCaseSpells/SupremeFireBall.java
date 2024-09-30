package Equipement.Spells.SpecialCaseSpells;

import Equipement.Spells.Spell;
import GameRule.Board.Case;

public class SupremeFireBall extends Spell implements Case {

    /// constructor ///
    public SupremeFireBall() {
        super("SupremFireBall","Spell");
        this.powerBonus = 7;
        this.lvl = 1;
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "SupremeFireBall{" +
                "powerBonus=" + powerBonus +
                ", lvl=" + lvl +
                '}';
    }
}
