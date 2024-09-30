package Monster;

import GameRule.Board.Case;

import java.util.Comparator;

public class Dragon extends Monster implements Case {

    public Dragon() {
        super("Red Dragon", "Dragon");
        this.attackDommage = 2;
        this.health = 9;
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "Dragon{" +
                "attackDommage=" + attackDommage +
                ", health=" + health +
                '}';
    }
}
