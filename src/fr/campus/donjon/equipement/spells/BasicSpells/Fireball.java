package fr.campus.donjon.equipement.spells.BasicSpells;

import fr.campus.donjon.equipement.spells.Spell;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.inventory.Items;

public class Fireball extends Spell{

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
