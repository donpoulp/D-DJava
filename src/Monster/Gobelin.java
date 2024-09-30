package Monster;

import GameRule.Board.Case;

public class Gobelin extends Monster implements Case {

    public Gobelin() {
        super("Little Gobelin", "Gobelin");
        this.attackDommage = 2;
        this.health = 9;
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "Gobelin{" +
                "attackDommage=" + attackDommage +
                ", health=" + health +
                '}';
    }
}
