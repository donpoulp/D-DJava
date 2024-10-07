package fr.campus.donjon.game.board;

import fr.campus.donjon.personnage.Personnage;

public class CaseEmpty implements Case{
    String name = "caseEmpty";
    String emoji = Character.toString(0x2753);

    @Override
    public String toString() {
        return emoji + " Case Vide";
    }


    @Override
    public void caseInteract(Personnage p, Case currentCase, int position, Board board){}
}
