package Equipement.Weapons.SpecialCaseWeapons;

import Equipement.Weapons.Weapon;
import GameRule.Board.Case;
import Personnage.Inventory.Items;

public class LépéeNice extends Weapon implements Case, Items {

    /// constructor ///
    public LépéeNice() {
        super("LépéeNice", "Sword");
        this.powerBonus = 1;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F9A9);
    }

    /// getter ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " L'épée Nice : {" +
                " puissance bonus = " + powerBonus +
                " , lvl = " + lvl +
                " }";
    }
}
