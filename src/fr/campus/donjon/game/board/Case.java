package fr.campus.donjon.game.board;

import fr.campus.donjon.exeption.PersonnageOffStageException;
import fr.campus.donjon.personnage.Personnage;

public interface Case {

    void caseInteract(Personnage p, Case currentCase, int position, Board board) throws InterruptedException, PersonnageOffStageException;
}
