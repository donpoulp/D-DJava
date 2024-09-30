package Equipement.Shields.SpecialCaseShields;

import Equipement.Shields.Shield;
import GameRule.Board.Case;

public class IronShield extends Shield implements Case {


    /// constructor ///
    public IronShield() {
        super("IronShields","Shield");
        this.defenseBonus = 3;
        this.lvl = 1;
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "IronShield{" +
                "defenseBonus=" + defenseBonus +
                ", lvl=" + lvl +
                '}';
    }
}
