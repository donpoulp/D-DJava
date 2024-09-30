package Equipement.Philters.SpecialCasePhilters;

import Equipement.Philters.Philter;
import GameRule.Board.Case;

public class LittleHealthPotion extends Philter implements Case {

    /// constructor ///
    public LittleHealthPotion() {
        super("LittleHealthPotion", "HealthPotion");
        LifePoint = 2;
        lvl = 1;
    }

    /// getters ///

    /// setters ///

    /// ToString ///
    @Override
    public String toString() {
        return "LittleHealthPotion{" +
                "LifePoint=" + LifePoint +
                ", lvl=" + lvl +
                '}';
    }
}
