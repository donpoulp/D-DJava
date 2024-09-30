package Equipement.Weapons.SpecialCaseWeapons;

import Equipement.Weapons.Weapon;
import GameRule.Board.Case;

public class GoldSword extends Weapon implements Case {

    /// constructor ///
    public GoldSword() {
        super("GoldSword", "Sword");
        this.powerBonus = 1;
        this.lvl = 1;
    }

    /// getter ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "GoldSword{" +
                ", name = " + this.getName() +
                ", powerBonus = " + powerBonus +
                ", lvl =  " + lvl +
                '}';
    }
}
