package fr.campus.donjon.equipement.weapons.SpecialCaseWeapons;

import fr.campus.donjon.equipement.weapons.Weapon;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.inventory.Items;

public class LépéeNice extends Weapon {

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
