package fr.campus.donjon.equipement.spells;

import fr.campus.donjon.equipement.OffensiveEquipment;
import fr.campus.donjon.equipement.weapons.Weapon;
import fr.campus.donjon.exeption.UserInputException;
import fr.campus.donjon.game.Game;
import fr.campus.donjon.game.board.Board;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.Personnage;
import fr.campus.donjon.personnage.Warrior;
import fr.campus.donjon.personnage.Wizard;
import fr.campus.donjon.personnage.inventory.Items;

import javax.smartcardio.Card;
import java.util.Scanner;

public abstract class Spell extends OffensiveEquipment implements Case, Items {
    protected int powerBonus;
    protected int lvl;
    protected String emoji;

    public Spell(String name, String type) {
        super(name, type);
        this.type = type;
    }

    public int getPowerBonus() {return powerBonus;}
    public int getLvl() {return lvl;}
    public String getEmoji() {return emoji;}

    public void setPowerBonus(int powerBonus) {this.powerBonus = powerBonus;}
    public void setLvl(int lvl) {this.lvl = lvl;}

    @Override
    public void caseInteract(Personnage p, Case currentCase, int position, Board board){
        Scanner sc = new Scanner(System.in);
        if (p instanceof Wizard) {
            System.out.println("Votre personnage possède déja : " + ((Wizard) p).getSpell());
            System.out.println("\nTapez 1 pour vous équipez de la nouvelle arme\nTapez 2 pour gardez votre ancienne et stocker celle-ci dans l'inventaire\nTapez 3 pour jeter celle que vous venez de trouver");
            int userChoice = sc.nextInt();

            switch (userChoice){
                case 1: equipItem(p, currentCase); break;
                case 2: addItemInInventory(p, currentCase); break;
                case 3: break;
                default: throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            }
        }
    }

    public void equipItem(Personnage p, Case currentCase) {
        p.getInventory().addItem((Items) ((Wizard) p).getSpell());
        ((Wizard) p).setSpell((Spell) currentCase);
        System.out.println("Nouveau Sort équiper ! L'ancienne été transférer dans l'inventaire");
        System.out.println("\nAppuie sur entrée pour continuer");
    }

    public void addItemInInventory(Personnage p, Case currentCase) {
        p.getInventory().addItem((Items) currentCase);
        System.out.println("Sort ajouter a l'inventaire ! voicie votre inventaire actuel : " + p.getInventory());
        System.out.println("\nAppuie sur entrée pour continuer");
    }

    @Override
    public boolean itemInteract(Personnage personnage, int idItem) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nTape 1 pour équipé l'items selectionner\nTape 2 pour le supprimer");
        int userChoice = sc.nextInt();

        return switch (userChoice) {
            case 1 -> equipItemComeFromInventory(personnage, idItem);
            case 2 -> deleteItemComeFromInventory(personnage, idItem);
            default -> throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
        };
    }

    public boolean equipItemComeFromInventory(Personnage personnage, int idItem) {
        Scanner sc = new Scanner(System.in);
        if (personnage.getInventory().getInventory().get(idItem) instanceof Spell) {
            personnage.getInventory().addItem((Items) ((Wizard) personnage).getSpell());
            ((Wizard) personnage).setSpell((Spell) personnage.getInventory().getInventory().get(idItem));
            personnage.getInventory().getInventory().remove(idItem);
            System.out.println("Tu t'es équipé de : " + ((Wizard) personnage).getSpell());
            System.out.println("T'on ancienne items à été envoyer dans l'inventaire !" + "\n");
            System.out.println("\nTape 1 pour revenir au jeu\nTape 2 pour rester dans l'inventaire");
            int userChoice = sc.nextInt();

            return switch (userChoice) {
                case 1 -> false;
                case 2 -> true;
                default ->  throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            };
        }
        return false;
    }

    public boolean deleteItemComeFromInventory(Personnage personnage, int idItem) {
        Scanner sc = new Scanner(System.in);
        personnage.getInventory().getInventory().remove(idItem);
        System.out.println("Item supprimé !\n\nTape 1 pour revenir au jeu\nTape 2 pour rester dans l'inventaire");
        int userChoice = sc.nextInt();

        return switch(userChoice){
            case 1 -> false;
            case 2 -> true;
            default ->  throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
        };
    }
}
