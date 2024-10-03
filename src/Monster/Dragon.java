package Monster;

import GameRule.Board.Case;

import java.util.Comparator;

public class Dragon extends Monster implements Case {

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
