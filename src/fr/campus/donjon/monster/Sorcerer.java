package fr.campus.donjon.monster;

import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.Personnage;

public class Sorcerer extends Monster {

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
