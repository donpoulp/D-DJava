package Equipement.Weapons.SpecialCaseWeapons;

import Equipement.Weapons.Weapon;
import GameRule.Board.Case;
import Personnage.Inventory.Items;

public class GoldSword extends Weapon implements Case, Items {


    /// constructor ///
    public GoldSword() {
        super("GoldSword", "Sword");
        this.powerBonus = 1;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F5E1);
    }

    /// getter ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Epée en or : {" +
                " puissance bonus = " + powerBonus +
                " , lvl = " + lvl +
                " }";
    }
}
