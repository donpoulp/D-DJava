package fr.campus.donjon.equipement.philters.BasicPhilters;

import fr.campus.donjon.equipement.philters.Philter;
import fr.campus.donjon.personnage.inventory.Items;

public class MedicinalHerb extends Philter {

    /// constructor ///
    public MedicinalHerb() {
        super("MedicinalHerb", "Philter");
        this.LifePoint = 2;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F33F);
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return emoji + " Herbe medicinal : {" +
                " PV restauré = " + LifePoint +
                " , lvl = " + lvl +
                " }";
    }
}
