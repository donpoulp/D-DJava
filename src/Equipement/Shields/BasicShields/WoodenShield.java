package Equipement.Shields.BasicShields;

import Equipement.Shields.Shield;
import Personnage.Inventory.Items;

public class WoodenShield extends Shield  implements Items {

    /// constructor ///
    public WoodenShield() {
        super("WoodenShield", "Shield");
        this.defenseBonus = 1;
        this.lvl = 1;
        this.emoji = Character.toString(0x1FAB5);
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return emoji + " Bouclier en bois : {" +
                " defenseBonus = " + defenseBonus +
                " , lvl = " + lvl +
                " }";
    }
}
