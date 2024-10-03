package Equipement.Shields.BasicShields;

import Equipement.Shields.Shield;
import GameRule.Board.Case;
import Personnage.Inventory.Items;

public class PaperShield extends Shield  implements Items {

    /// constructor ///
    public PaperShield() {
        super("PaperShield", "Shield");
        this.defenseBonus = 1;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F9FB);
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return emoji + " Bouclier de papier : {" +
                " defenseBonus = " + defenseBonus +
                " , lvl = " + lvl +
                " }";
    }
}
