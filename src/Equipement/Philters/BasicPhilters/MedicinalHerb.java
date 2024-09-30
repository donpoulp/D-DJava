package Equipement.Philters.BasicPhilters;

import Equipement.Philters.Philter;

public class MedicinalHerb extends Philter {

    /// constructor ///
    public MedicinalHerb() {
        super("MedicinalHerb", "Philter");
        this.LifePoint = 2;
        this.lvl = 1;
    }

    /// getters ///

    /// setters ///

    /// tostring ///
    @Override
    public String toString() {
        return "MedicinalHerb{" +
                ", name = " + this.getName() +
                ", defenseBonus = " + getLifePoint() +
                ", lvl = " + lvl +
                '}';
    }
}
