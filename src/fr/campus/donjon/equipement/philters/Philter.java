package fr.campus.donjon.equipement.philters;

import fr.campus.donjon.equipement.DefensiveEquipement;
import fr.campus.donjon.equipement.shields.Shield;
import fr.campus.donjon.exeption.UserInputException;
import fr.campus.donjon.game.Game;
import fr.campus.donjon.game.board.Board;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.personnage.Personnage;
import fr.campus.donjon.personnage.Warrior;
import fr.campus.donjon.personnage.inventory.Items;

import java.util.Scanner;

public abstract class Philter extends DefensiveEquipement implements Case, Items {
    protected int LifePoint;
    protected int lvl;
    protected String emoji;

    public Philter(String name ,String type) {
        super(name, type);
        this.type = type;
    }

    public int getLifePoint() {return LifePoint;}
    public int getLvl() {return lvl;}
    public String getEmoji() {return emoji;}

    public void setLvl(int lvl) {this.lvl = lvl;}
    public void setLifePoint(int lifePoint) {this.LifePoint = lifePoint;}

    @Override
    public String toString() {
        return "Philter{" +
                "type='" + type + '\'' +
                ", LifePoint=" + LifePoint +
                ", lvl=" + lvl +
                '}';
    }

    @Override
    public void caseInteract(Personnage p, Case currentCase, int position, Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu a actuellement : " + p.getHealth() + "/" + p.getMaxHealth() + " PV");
        System.out.println("Tape 1 pour la jeter");
        System.out.println("Tape 2 pour la stocker dans l'inventaire");
        if (p.getHealth() < p.getMaxHealth()) {
            System.out.println("Tape 3 pour boire la potion immediatement");
        }
        int userChoice = sc.nextInt();

        switch (userChoice) {
            case 1: break;
            case 2: addItemInInventory(p, currentCase);
            case 3: drinkPhilter(p, currentCase); break;
            default:
        }
    }

    public void drinkPhilter(Personnage p, Case currentCase){
        if (p.getHealth() < p.getMaxHealth()) {
            if (p.getHealth() + ((Philter) currentCase).getLifePoint() > p.getMaxHealth()) {
                p.setHealth(p.getMaxHealth());
            }else {
                p.setHealth(p.getHealth() + ((Philter) currentCase).getLifePoint());
            }
            System.out.println("La vie de votre personnage a été modifier il a maintenant : " + p.getHealth() + "\n");
            System.out.println("\nAppuie sur entrée pour continuer");
        }
    }

    public void addItemInInventory(Personnage p, Case currentCase){
        p.getInventory().addItem((Items) currentCase);
        System.out.println("Potion ajouter a l'inventaire ! voicie votre inventaire actuel : " + p.getInventory());
        System.out.println("\nAppuie sur entrée pour continuer");
    }

    @Override
    public boolean itemInteract(Personnage personnage, int idItem) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        if (personnage.getInventory().getInventory().get(idItem) instanceof Philter) {
            System.out.println("Tu a actuellement : " + personnage.getHealth() + "/" + personnage.getMaxHealth() + " PV\n");
            if (personnage.getHealth() < personnage.getMaxHealth()) {
                System.out.println("Tape 1 pour boire la potion immediatement");
            }
            System.out.println("Tape 2 pour supprimer la potion de ton inventaire");
            int userChoice = sc.nextInt();

            return switch (userChoice){
                case 1 -> drinkPhilterComeFromInventory(personnage, idItem);
                case 2 -> deleteItemComeFromInventory(personnage, idItem);
                default ->  throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            };
        }
        return false;
    }

    public boolean drinkPhilterComeFromInventory(Personnage personnage, int idItem){
        Scanner sc = new Scanner(System.in);
        if (personnage.getHealth() < personnage.getMaxHealth()) {
            if (personnage.getHealth() + ((Philter) personnage.getInventory().getInventory().get(idItem)).getLifePoint() > personnage.getMaxHealth()) {
                personnage.setHealth(personnage.getMaxHealth());
            } else {
                personnage.setHealth(personnage.getHealth() + ((Philter) personnage.getInventory().getInventory().get(idItem)).getLifePoint());
            }
            System.out.println("La vie de votre personnage a été modifier il a maintenant : " + personnage.getHealth() + "\n");
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

    public boolean deleteItemComeFromInventory(Personnage personnage, int idItem){
        Scanner sc = new Scanner(System.in);
        personnage.getInventory().getInventory().remove(idItem);
        System.out.println("Potion supprimé pas sur de tes choix strategique !\n\nTape 1 pour revenir au jeu\nTape 2 pour rester dans l'inventaire");
        int userChoice = sc.nextInt();

        return switch (userChoice) {
            case 1 -> false;
            case 2 -> true;
            default ->  throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
        };
    }
}
