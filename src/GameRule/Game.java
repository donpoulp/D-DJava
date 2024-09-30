package GameRule;
import Equipement.Philters.Philter;
import Equipement.Shields.Shield;
import Equipement.Spells.Spell;
import Equipement.Weapons.Weapon;
import Execption.PersonnageOffStageException;
import GameRule.Board.Board;
import GameRule.Board.Case;
import Monster.*;
import Personnage.Personnage;
import java.lang.InterruptedException;
import java.util.ArrayList;
import java.util.Scanner;
import Personnage.Wizard;
import Personnage.Warrior;

public class Game {
    Board board;
    Personnage personnage;

    static String z = Character.toString(0x2694);
    static String y = Character.toString(0x1F332);
    static String i = Character.toString(0x1F4A6);
    static String k = Character.toString(0x1F334);
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public Game(Personnage personnage){
        this.board = new Board(63);
        this.personnage = personnage;
    }

    /// getters ///
    public Board getBoard() {return board;}
    public Personnage getPersonnage() {return personnage;}

    /// setters ///
    public void setBoard(Board board) {this.board = board;}
    public void setPersonnage(Personnage personnage) {this.personnage = personnage;}

    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
                ", personnage=" + personnage +
                '}';
    }

    public void play() throws InterruptedException, PersonnageOffStageException {
        Scanner sc = new Scanner(System.in);
        Board board = new Board(63);
        ArrayList<Case> getBoard = board.getBoard();

        boolean green = false;
        boolean blue = false;
        boolean yellow = false;
        //ArrayList<Case> caseArrayList = new ArrayList<Case>();

        int position = 0;
        /// define the range of my dé ///
        int maxRange = 6;
        int minRange = 1;
        int range = maxRange - minRange + 1;


        System.out.println("\nAppuyer sur n'importe quel touche du clavier pour jouer les tours\n");
        while (position != getBoard.size()) {
            new Scanner(System.in).nextLine();
            if(position < 0 || position > getBoard.size()){
                throw new PersonnageOffStageException("ERROR : votre personnage est sortie du plateau !!!\n Pas de chance recommence du debut");
            }else{
                if (position >= 0 && position < 20){
                    if (!green) {
                        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + "YOU ENTER IN THE FOREST !  " + y + y + y + y);

                        green = true;
                    }
                }else if (position >= 20 && position < 40){
                    if (!blue) {
                        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + "YOU ENTER IN THE SWAMP !   " + i + i + i + i);

                        blue = true;
                    }
                }else if ( position >= 40){
                    if (!yellow) {
                        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "YOU ENTER IN THE DESERT !" + k + k + k + k);

                        yellow = true;
                    }
                }

                System.out.println("position sur le plateau : " + position);
                int dé = (int)(Math.random() * range)+ minRange;
                System.out.println("dé : " + dé);
                System.out.println("la case contient : " + getBoard.get(position) + "\n");

                /// Ajout des regles de chaque case ///
                Case currentCase = board.getBoard().get(position);
                if (currentCase instanceof Weapon){
                    if (personnage instanceof Warrior) {
                        personnage.setAttackForce(personnage.getAttackForce() + ((Weapon) currentCase).getPowerBonus());
                        System.out.println("L'attack de votre personnage a été modifier il a maintenant : " + personnage.getAttackForce() + "\n");
                    }
                } else if (currentCase instanceof Spell) {
                    if (personnage instanceof Wizard) {
                        personnage.setAttackForce(personnage.getAttackForce() + ((Spell) currentCase).getPowerBonus());
                        System.out.println("La puissance magique de votre personnage a été modifier il a maintenant : " + personnage.getAttackForce() + "\n");
                    }
                } else if (currentCase instanceof Shield) {
                    if (personnage instanceof Warrior){
                        ((Warrior) personnage).setDefenseBonus(((Warrior) personnage).getDefenseBonus() + ((Shield) currentCase).getDefenseBonus());
                        System.out.println("La defense de votre personnage a été modifier il a maintenant : " + ((Warrior) personnage).getDefenseBonus() + "\n");
                    }
                } else if (currentCase instanceof Philter) {
                    personnage.setHealth(personnage.getHealth() + ((Philter) currentCase).getLifePoint());
                    System.out.println("La vie de votre personnage a été modifier il a maintenant : " + personnage.getHealth() + "\n");
                } else if (currentCase instanceof Monster) {
                    battle(currentCase);
                }


                position = position + dé;
            }
        }
        Menu menu = new Menu();
        menu.reGame();
    }

    private void battle(Case currentCase) {
        int countRound = 1;
        System.out.println(z + z + " Tu entre en combat ! " + z + z);
        while(personnage.getHealth() > 0 && ((Monster) currentCase).getHealth() > 0) {
            new Scanner(System.in).nextLine();
            System.out.println("\n" + z + z + " Tour n°" + countRound);
            System.out.println("Votre personnage attack il a : " + personnage.getAttackForce() + " d'attack");
            ((Monster) currentCase).setHealth(((Monster) currentCase).getHealth() - personnage.getAttackForce());
            System.out.println("Le monstre a perdu " + personnage.getAttackForce() + " PV, il a maintenant " + ((Monster) currentCase).getHealth() + " PV");
            if (((Monster) currentCase).getHealth() >= 0) {
                new Scanner(System.in).nextLine();
                System.out.println("\nC'est maintenant au monstre d'attaquer ! Il a : " + ((Monster) currentCase).getAttackDommage() + " d'attack");
                if (personnage instanceof Wizard) {
                    personnage.setHealth(personnage.getHealth() - ((Monster) currentCase).getAttackDommage());
                } else if (personnage instanceof Warrior) {
                    personnage.setHealth(personnage.getHealth() - (((Monster) currentCase).getAttackDommage() - ((Warrior) personnage).getDefenseBonus()));
                }
                System.out.println("Votre personnage a perdu " + ((Monster) currentCase).getAttackDommage() + " PV, Il a maintenant " + personnage.getHealth() + " PV");
            }
            if (personnage.getHealth() <= 0 ){
                System.out.println("\nVotre personnage est mort !! YOU LOOS");
            } else if (((Monster) currentCase).getHealth() <= 0) {
                System.out.println("\nLe monstre est mort !! You Win this battle !");
            }
            countRound++;
        }
    }
}
