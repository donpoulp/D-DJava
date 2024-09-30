package Equipement.Philters.BasicPhilters;

import Equipement.Philters.Philter;

public class HealPotion extends Philter {

    /// constructor ///
    public HealPotion() {
        super("HealPotion", "Philter");
        this.LifePoint = 2;
        this.lvl = 1;
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return "HealPotion{" +
                ", name = " + this.getName() +
                ", defenseBonus = " + getLifePoint() +
                ", lvl = " + lvl +
                '}';
    }
}
