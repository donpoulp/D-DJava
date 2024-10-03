package Equipement.Philters.SpecialCasePhilters;

import Equipement.Philters.Philter;
import GameRule.Board.Case;
import Personnage.Inventory.Items;

public class BigHealthPotion extends Philter implements Case, Items {

    /// constructor ///
    public BigHealthPotion() {
        super("BigHealthPotion", "HealthPotion");
        this.LifePoint = 5;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F9EB);
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Grosse potion de soin : {" +
                " PV restauré = " + LifePoint +
                " , lvl = " + lvl +
                " }";
    }
}
