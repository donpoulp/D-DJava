package Equipement.Shields.SpecialCaseShields;

import Equipement.Shields.Shield;
import GameRule.Board.Case;
import Personnage.Inventory.Items;

public class IronShield extends Shield implements Case, Items {

    /// constructor ///
    public IronShield() {
        super("IronShield","Shield");
        this.defenseBonus = 2;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F6E1);
    }

    /// getters ///


    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Bouclier en fer : {" +
                " defenseBonus = " + defenseBonus +
                " , lvl = " + lvl +
                " }";
    }
}
