package fr.campus.donjon.equipement.philters.SpecialCasePhilters;

import fr.campus.donjon.equipement.philters.Philter;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.inventory.Items;

public class LittleHealthPotion extends Philter {

    /// constructor ///
    public LittleHealthPotion() {
        super("LittleHealthPotion", "HealthPotion");
        LifePoint = 2;
        lvl = 1;
        this.emoji = Character.toString(0x1F9EA);
    }

    /// getters ///

    /// setters ///

    /// ToString ///
    @Override
    public String toString() {
        return emoji + " Petite potion de soin : {" +
                " PV restauré = " + LifePoint +
                " , lvl = " + lvl +
                " }";
    }
}
