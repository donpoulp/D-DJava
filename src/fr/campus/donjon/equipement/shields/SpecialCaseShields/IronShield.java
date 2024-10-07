package fr.campus.donjon.equipement.shields.SpecialCaseShields;

import fr.campus.donjon.equipement.shields.Shield;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.inventory.Items;

public class IronShield extends Shield {

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
