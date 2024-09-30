package Equipement.Weapons.SpecialCaseWeapons;

import Equipement.Weapons.Weapon;
import GameRule.Board.Case;

public class LépéeNice extends Weapon implements Case {

    /// constructor ///
    public LépéeNice() {
        super("LépéeNice", "Sword");
        this.powerBonus = 1;
        this.lvl = 1;
    }

    /// getter ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "LépéeNice{" +
                ", name = " + this.getName() +
                ", powerBonus = " + powerBonus +
                ", lvl =  " + lvl +
                '}';
    }
}
