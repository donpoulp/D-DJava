package Monster;

import GameRule.Board.Case;

public class Sorcerer extends Monster implements Case {

    public Sorcerer() {
        super("Black Sorcerer", "Sorcerer");
        this.attackDommage = 2;
        this.health = 9;
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return "Sorcerer{" +
                "attackDommage=" + attackDommage +
                ", health=" + health +
                '}';
    }
}
