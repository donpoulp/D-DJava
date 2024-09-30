package Equipement.Spells.BasicSpells;

import Equipement.Spells.Spell;

public class IceBold extends Spell {

    /// contructor ///
    public IceBold() {
        super("IceBold", "Spell");
        this.powerBonus = 2;
        this.lvl = 1;
    }
    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "IceBold{" +
                ", name = " + this.getName() +
                ", powerBonus = " + powerBonus +
                ", lvl = " + lvl +
                '}';
    }
}
