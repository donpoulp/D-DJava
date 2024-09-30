package Execption;

import GameRule.Game;

public class PersonnageOffStageException extends Exception {
    public PersonnageOffStageException(String message) {
        super(message);
        //System.out.println("Votre personnage est sortie du plateau !!!\n recommance au debut");
    }
}
