package Equipement.Spells.BasicSpells;

import Equipement.Spells.Spell;
import Personnage.Inventory.Items;

public class Fireball extends Spell implements Items {

    /// contructor ///
    public Fireball() {
        super("Fireball", "Spell");
        this.powerBonus = 2;
        this.lvl = 1;
        this.emoji = Character.toString(0x1F525);
    }
    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Boule de feu : {" +
                " puissance bonus = " + powerBonus +
                " , lvl = " + lvl +
                " }";
    }
}
