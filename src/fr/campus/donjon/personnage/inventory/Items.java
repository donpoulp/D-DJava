package fr.campus.donjon.personnage.inventory;

import fr.campus.donjon.personnage.Personnage;

public interface Items {
    boolean itemInteract(Personnage personnage, int idItem) throws InterruptedException;
}
