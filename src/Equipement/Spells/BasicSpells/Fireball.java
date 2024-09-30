package Equipement.Spells.BasicSpells;

import Equipement.Spells.Spell;

public class Fireball extends Spell {

    /// contructor ///
    public Fireball() {
        super("Fireball", "Spell");
        this.powerBonus = 2;
        this.lvl = 1;
    }
    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "Fireball{" +
                ", name = " + this.getName() +
                ", powerBonus = " + powerBonus +
                ", lvl = " + lvl +
                '}';
    }
}
