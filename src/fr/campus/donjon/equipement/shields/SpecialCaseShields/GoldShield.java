package fr.campus.donjon.equipement.shields.SpecialCaseShields;

import fr.campus.donjon.equipement.shields.Shield;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.inventory.Items;

public class GoldShield extends Shield {

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
