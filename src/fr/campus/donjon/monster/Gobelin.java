package fr.campus.donjon.monster;

import fr.campus.donjon.game.board.Case;

public class Gobelin extends Monster {

    public Gobelin() {
        super("Gobelin", "Gobelin");
        this.attackDommage = 3;
        this.health = 9;
        this.emoji = Character.toString(0x1F479);
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Gobelin : { " +
                " Attack = " + attackDommage +
                " , PV = " + health +
                '}';
    }
}
