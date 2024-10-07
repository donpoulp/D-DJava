package fr.campus.donjon.monster;

import fr.campus.donjon.equipement.philters.Philter;
import fr.campus.donjon.exeption.PersonnageOffStageException;
import fr.campus.donjon.exeption.UserInputException;
import fr.campus.donjon.game.Game;
import fr.campus.donjon.game.board.Board;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.game.board.CaseEmpty;
import fr.campus.donjon.personnage.Personnage;
import fr.campus.donjon.personnage.Warrior;
import fr.campus.donjon.personnage.Wizard;
import fr.campus.donjon.personnage.inventory.Items;

import java.util.Scanner;

public abstract class Monster implements Case{
    String name;
    String type;
    protected int attackDommage;
    protected int health;
    protected String emoji;

    /// constructor ///
    public Monster(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /// getters ///
    public String getName() {return name;}
    public String getType() {return type;}
    public int getAttackDommage() {return attackDommage;}
    public int getHealth() {return health;}
    public String getEmoji() {return emoji;}

    /// setters ///
    public void setName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}
    public void setHealth(int health) {this.health = health;}


    /// toString ///
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void caseInteract(Personnage p, Case currentCase, int position, Board board) throws InterruptedException, PersonnageOffStageException {
        int maxRange = 6;
        int minRange = 1;
        int range = maxRange - minRange + 1;

        if (currentCase instanceof Monster) {
            if (!battle(currentCase, p)) {
                int battleLoose = (int) (Math.random() * range) + minRange;
                if (position - battleLoose >= 0) {
                    position = position - battleLoose;
                    currentCase = board.getBoard().get(position);
                    System.out.println("position sur le plateau : " + position);
                    System.out.println("la case contient : " + board.getBoard().get(position) + "\n");
                    currentCase.caseInteract(p, currentCase, position, board);
                } else {
                    position = 0;
                    currentCase = board.getBoard().get(position);
                    throw new PersonnageOffStageException("Votre personnage est sortie du plateau !!! Big Noob recommence au début !! ça t'apprendra a fuir les combats !!");
                }
            } else {
                currentCase = new CaseEmpty();
            }
        }
    }

    private boolean battle(Case currentCase, Personnage personnage) throws InterruptedException {
        String z = Character.toString(0x2694);
        Scanner sc = new Scanner(System.in);

        System.out.println(z + z + " Tu entre en combat ! " + z + z);

        while (personnage.getHealth() > 0 && ((Monster) currentCase).getHealth() > 0) {
            System.out.println("\nTu peut te battre comme un homme ou fuir comme un lâche !");
            System.out.println("\nTape 1 pour te BATTRE !\nTape 2 pour fuir comme une lopsa !");
            int userChoice = sc.nextInt();

            return switch (userChoice) {
                case 1 -> fight(personnage, currentCase);
                case 2 -> false;
                default -> throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            };
        }
        return true;
    }

    public boolean fight(Personnage personnage, Case currentCase) throws InterruptedException {
        String z = Character.toString(0x2694);
        Scanner sc = new Scanner(System.in);
        int countRound = 1;
        int PvBeforeBattle = personnage.getHealth();

        System.out.println(z + z + " Tour n°" + countRound + "\n");
        if (personnage instanceof Wizard) {
            System.out.println("Votre personnage attack il a : " + (personnage.getAttackForce() + ((Wizard) personnage).getSpell().getPowerBonus()) + " d'attack");
            ((Monster) currentCase).setHealth(((Monster) currentCase).getHealth() - (personnage.getAttackForce() + ((Wizard) personnage).getSpell().getPowerBonus()));
            if (((Monster) currentCase).getHealth() < 0) {
                ((Monster) currentCase).setHealth(0);
            }
            System.out.println("Le monstre a perdu " + (personnage.getAttackForce() + ((Wizard) personnage).getSpell().getPowerBonus()) + " PV, il a maintenant " + ((Monster) currentCase).getHealth() + " PV");
        } else if (personnage instanceof Warrior) {
            System.out.println("Votre personnage attack il a : " + (personnage.getAttackForce() + ((Warrior) personnage).getWeapons().getPowerBonus()) + " d'attack");
            ((Monster) currentCase).setHealth(((Monster) currentCase).getHealth() - (personnage.getAttackForce() + ((Warrior) personnage).getWeapons().getPowerBonus()));
            if (((Monster) currentCase).getHealth() < 0) {
                ((Monster) currentCase).setHealth(0);
            }
            System.out.println("Le monstre a perdu " + (personnage.getAttackForce() + ((Warrior) personnage).getWeapons().getPowerBonus()) + " PV, il a maintenant " + ((Monster) currentCase).getHealth() + " PV");
        }

        if (((Monster) currentCase).getHealth() > 0) {
            System.out.println("\nC'est maintenant au monstre d'attaquer ! Il a : " + ((Monster) currentCase).getAttackDommage() + " d'attack");
            if (personnage instanceof Wizard) {
                personnage.setHealth(personnage.getHealth() - ((Monster) currentCase).getAttackDommage());
                System.out.println("Votre personnage a perdu " + ((Monster) currentCase).getAttackDommage() + " PV, Il a maintenant " + personnage.getHealth() + " PV");
            } else if (personnage instanceof Warrior) {
                personnage.setHealth(personnage.getHealth() - (((Monster) currentCase).getAttackDommage() - ((((Warrior) personnage).getDefenseBonus()) + ((Warrior) personnage).getShield().getDefenseBonus())));
                System.out.println("Votre personnage a perdu " + ((Monster) currentCase).getAttackDommage() + " PV, mais il a resister de " + (((Warrior) personnage).getShield().getDefenseBonus() + ((Warrior) personnage).getDefenseBonus()) + " PV, Il a maintenant " + personnage.getHealth() + " PV");
            }
        }
        if (personnage.getHealth() <= 0) {
            System.out.println("\nVotre personnage est mort !! YOU LOOS");
        } else if (((Monster) currentCase).getHealth() <= 0) {
            System.out.println("\nLe monstre est mort !! You Win this battle !\n");
            if (personnage.getHealth() != PvBeforeBattle){
                for (Items i : personnage.getInventory().getInventory()) {
                    if (i instanceof Philter){
                        System.out.println("Lors de ce combat tu a perdue des PV !\n\nTape 1 pour ouvrir l'inventaire et utiliser une potion\nTape 2 pour passer a la suite");
                        int userChoice = sc.nextInt();
                        if (userChoice == 1) {
                            Game game = new Game();
                            game.openInventory();
                            if (personnage.getHealth() == personnage.getMaxHealth()) {
                                break;
                            }
                        } else if (userChoice == 2) {
                            return true;
                        }
                    }
                }
            }
            return true;
        }
        countRound++;
        return true;
    }
}
