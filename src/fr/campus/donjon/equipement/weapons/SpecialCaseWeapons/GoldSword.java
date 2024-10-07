package fr.campus.donjon.equipement.weapons.SpecialCaseWeapons;

import fr.campus.donjon.equipement.weapons.Weapon;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.inventory.Items;

public class GoldSword extends Weapon {


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
