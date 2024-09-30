package Equipement.Shields.SpecialCaseShields;

import Equipement.Shields.Shield;
import GameRule.Board.Case;

public class GoldShield extends Shield implements Case {

    /// constructor ///
    public GoldShield() {
        super("GoldShield","Shield");
        this.defenseBonus = 2;
        this.lvl = 10000;
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "GoldShield{" +
                "defenseBonus=" + defenseBonus +
                ", lvl=" + lvl +
                '}';
    }
}
