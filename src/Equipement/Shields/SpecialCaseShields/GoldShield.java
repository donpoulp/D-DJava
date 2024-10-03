package Equipement.Shields.SpecialCaseShields;

import Equipement.Shields.Shield;
import GameRule.Board.Case;
import Personnage.Inventory.Items;

public class GoldShield extends Shield implements Case, Items {

    /// constructor ///
    public GoldShield() {
        super("GoldShield","Shield");
        this.defenseBonus = 2;
        this.lvl = 10000;
        this.emoji = Character.toString(0x1F536);
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Bouclier en or : {" +
                " defenseBonus = " + defenseBonus +
                " , lvl = " + lvl +
                " }";
    }
}
