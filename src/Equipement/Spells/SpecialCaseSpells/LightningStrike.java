package Equipement.Spells.SpecialCaseSpells;

import Equipement.Spells.Spell;
import GameRule.Board.Case;

public class LightningStrike extends Spell implements Case {

    /// constructor ///
    public LightningStrike() {
        super("LightningStrike","Spell");
        this.powerBonus = 7;
        this.lvl = 1;
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "LightningStrike{" +
                "powerBonus=" + powerBonus +
                ", lvl=" + lvl +
                '}';
    }
}
