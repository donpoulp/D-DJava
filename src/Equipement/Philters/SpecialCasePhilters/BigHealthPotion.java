package Equipement.Philters.SpecialCasePhilters;

import Equipement.Philters.Philter;
import GameRule.Board.Case;

public class BigHealthPotion extends Philter implements Case {

    /// constructor ///
    public BigHealthPotion() {
        super("BigHealthPotion", "HealthPotion");
        this.LifePoint = 5;
        this.lvl = 1;
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "BigHealthPotion{" +
                "LifePoint=" + LifePoint +
                ", lvl=" + lvl +
                '}';
    }
}
