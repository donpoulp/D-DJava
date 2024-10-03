package Equipement.Philters.SpecialCasePhilters;

import Equipement.Philters.Philter;
import GameRule.Board.Case;
import Personnage.Inventory.Items;

public class LittleHealthPotion extends Philter implements Case, Items {

    /// constructor ///
    public LittleHealthPotion() {
        super("LittleHealthPotion", "HealthPotion");
        LifePoint = 2;
        lvl = 1;
        this.emoji = Character.toString(0x1F9EA);
    }

    /// getters ///

    /// setters ///

    /// ToString ///
    @Override
    public String toString() {
        return emoji + " Petite potion de soin : {" +
                " PV restauré = " + LifePoint +
                " , lvl = " + lvl +
                " }";
    }
}
