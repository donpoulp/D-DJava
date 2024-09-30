package Equipement.Shields.BasicShields;

import Equipement.Shields.Shield;
import GameRule.Board.Case;

public class PaperShield extends Shield {

    /// constructor ///
    public PaperShield() {
        super("PaperShield", "Shield");
        this.defenseBonus = 5;
        this.lvl = 1;
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return "PaperShield{" +
                ", name = " + this.getName() +
                ", defenseBonus = " + defenseBonus +
                ", lvl = " + lvl +
                '}';
    }
}
