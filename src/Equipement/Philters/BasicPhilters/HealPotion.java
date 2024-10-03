package Equipement.Philters.BasicPhilters;

import Equipement.Philters.Philter;
import Personnage.Inventory.Items;

public class HealPotion extends Philter implements Items {

    /// constructor ///
    public HealPotion() {
        super("HealPotion", "Philter");
        this.LifePoint = 2;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F48A);
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return emoji + " Potion de soins : {" +
                " PV restauré = " + LifePoint +
                " , lvl = " + lvl +
                " }";
    }
}
