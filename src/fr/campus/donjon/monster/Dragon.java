package fr.campus.donjon.monster;

import fr.campus.donjon.game.board.Case;

public class Dragon extends Monster {

    public Dragon() {
        super("Dragon", "Dragon");
        this.attackDommage = 5;
        this.health = 12;
        this.emoji = Character.toString(0x1F409);
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Dragon : { " +
                " Attack = " + attackDommage +
                " , PV = " + health +
                '}';
    }
}
