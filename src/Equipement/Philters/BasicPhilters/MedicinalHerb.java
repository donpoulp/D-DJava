package Equipement.Philters.BasicPhilters;

import Equipement.Philters.Philter;
import Personnage.Inventory.Items;

public class MedicinalHerb extends Philter implements Items {

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
