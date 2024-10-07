package fr.campus.donjon.equipement.philters.SpecialCasePhilters;

import fr.campus.donjon.equipement.philters.Philter;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.inventory.Items;

public class BigHealthPotion extends Philter {

    /// constructor ///
    public BigHealthPotion() {
        super("BigHealthPotion", "HealthPotion");
        this.LifePoint = 5;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F9EB);
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Grosse potion de soin : {" +
                " PV restauré = " + LifePoint +
                " , lvl = " + lvl +
                " }";
    }
}
