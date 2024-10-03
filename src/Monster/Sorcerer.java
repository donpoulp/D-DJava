package Monster;

import GameRule.Board.Case;

public class Sorcerer extends Monster implements Case {

    public Sorcerer() {
        super("Sorcerer", "Sorcerer");
        this.attackDommage = 6;
        this.health = 10;
        this.emoji = Character.toString(0x1F9D9);
    }

    /// getters ///

    /// setters ///

    /// toString ///
    @Override
    public String toString() {
        return emoji + " Sorcier : { " +
                " Attack = " + attackDommage +
                " , PV = " + health +
                '}';
    }
}
