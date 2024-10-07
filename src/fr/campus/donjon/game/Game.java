package fr.campus.donjon.game;
import fr.campus.donjon.equipement.philters.Philter;
import fr.campus.donjon.equipement.shields.Shield;
import fr.campus.donjon.equipement.spells.Spell;
import fr.campus.donjon.equipement.weapons.Weapon;
import fr.campus.donjon.exeption.PersonnageOffStageException;
import fr.campus.donjon.exeption.UserInputException;
import fr.campus.donjon.game.board.Board;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.game.board.CaseEmpty;
import fr.campus.donjon.personnage.inventory.Items;
import fr.campus.donjon.personnage.Personnage;
import java.lang.InterruptedException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import fr.campus.donjon.personnage.Wizard;
import fr.campus.donjon.personnage.Warrior;
import fr.campus.donjon.database.DatabaseManagement;
import fr.campus.donjon.monster.Monster;

public class Game {
    Board board;
    Personnage personnage;
    int position;

    DatabaseManagement dbm = new DatabaseManagement();

    static String y = Character.toString(0x1F332);
    static String i = Character.toString(0x1F4A6);
    static String k = Character.toString(0x1F334);

    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RESET = "\u001B[0m";

    boolean green = false;
    boolean blue = false;
    boolean yellow = false;

    public Game(Personnage personnage) {
        this.board = new Board(63);
        this.personnage = personnage;
    }

    public Game(){}

    /// getters ///
    public Board getBoard() {return board;}
    public Personnage getPersonnage() {return personnage;}
    public int getPosition() {return position;}

    /// setters ///
    public void setBoard(Board board) {this.board = board;}
    public void setPersonnage(Personnage personnage) {this.personnage = personnage;}
    public void setPosition(int position) {this.position = position;}

    @Override
    public String toString() {
        return "Game : {" +
                "board = " + board +
                ", personnage = " + personnage +
                ", position = " + position +
                '}';
    }

    public void play() throws InterruptedException, PersonnageOffStageException, SQLException {
        if (board == null) {
            Board board = new Board(63);
        }
        ArrayList<Case> getBoard = board.getBoard();


        System.out.println(ANSI_RESET);
        System.out.println("\n*********************  Comment jouer ?  *************************");
        System.out.println("\nAppuyer sur entrée pour jouer les tours\n\nAppuyer sur i pour ouvrire l'inventaire a n'importe quel moment\n\nTape save dans la console pour sauvegarder et quitter la partie\n\n" + board + "\n");
        System.out.println("*****************************************************************");

        while (position != getBoard.size()) {   /// Boucle qui tourne TANT QUE la position du joueur n'est pas égale à la fin du plateau

            String playerInputRound = new Scanner(System.in).nextLine();
            int dice = RdmDice();

            if (position < 0 || position + dice > getBoard.size()) {     /// On vérifie que le personnage ne sort pas du plateau
                throw new PersonnageOffStageException("ERROR : votre personnage est sortie du plateau !!!\nPas de chance recommence du debut\n !! PS : Bouffon !! "); /// si il sort du plateau on renvoie une erreur personnaliser
            } else {
                if (!playRound(playerInputRound, dice)) {
                    break;
                }
            }
        }   /// ICI la partie est fini
        Menu menu = new Menu();
        menu.reGame();  /// on lance la fonction regame pour proposer au joueur de relancer une partie
    }

    public boolean playRound(String playerInputRound, int dice) throws SQLException, InterruptedException, PersonnageOffStageException {
        position = position + dice;
        if (personnage.getInventory().getInventory().size() > personnage.getInventory().getMaxSize()){
            inventoryFull();
        }
        if (playerInputRound.equals("i") || playerInputRound.equals("inventaire")) {
            if (!personnage.getInventory().getInventory().isEmpty()) {
                openInventory();
            }else {
                System.out.println("Inventaire vide !");
            }
        } else if (playerInputRound.equals("save") || playerInputRound.equals("SAVE") || playerInputRound.equals("Save")) {
            dbm.modifyPersonnage(dbm.getHeroByName(personnage.getName()), personnage);
            dbm.createSaveGame(dbm.getHeroByName(personnage.getName()) , board.getBoard(), position);
            return false;
        }

        createBiome();

        System.out.println("Tu lance le dé et tu fais : " + dice);   /// on affiche au joueur le chiffre aleatoire générer qui represente sont lancée de dé
        System.out.println("Le personnage avance juqu'à la case : " + position);  /// on affiche au joueur ça position sur le plateau
        System.out.println("\nLa case contient : " + board.getBoard().get(position) + "\n");      /// on affiche au joueur le contenue de la case ou il tombe

        /// Ajout des regles de chaque case ///
        Case currentCase = board.getBoard().get(position); /// on attribut le contenue de la case actuelle du joueur a une variable
        currentCase.caseInteract(personnage, currentCase, position, board);  /// un lance une fonction déclarer plus bas qui va verifier s'il y a une action à lancer en regardans la case sur laquel ce trouve notre personnage
        return true;
    }

    public int RdmDice(){
        /// define the range of my dé ///
        int maxRange = 6;
        int minRange = 1;
        int range = maxRange - minRange + 1;

        return (int) (Math.random() * range) + minRange;  /// on génère un chiffre aleatoire de 1 a 6
    }

    public void createBiome() {
        if (position >= 0 && position < 20) {   /// on introduit 3 biomes different en coloriant le fond la console en fonction de la position  de notre personnage
            if (!green) { /// on verifie si green est true pour afficher le message d'entrée dans un biome une seul fois
                System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + "YOU ENTER IN THE FOREST !  " + y + y + y + y + "\n");  /// utilisation de variable pour colorer le fonds et ajouter des smiley
                green = true;
            }
        } else if (position >= 20 && position < 40) {
            if (!blue) {
                System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + "YOU ENTER IN THE SWAMP !   " + i + i + i + i + "\n");
                blue = true;
            }
        } else if (position >= 40) {
            if (!yellow) {
                System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "YOU ENTER IN THE DESERT !" + k + k + k + k + "\n");
                yellow = true;
            }
        } if (position == 0){
            System.out.println("Votre personnage est sur la case de depart ! Bonne chance a toi\n");
        }
    }

    public void openInventory() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean inventoryOpen = true;

        while (inventoryOpen) {
            if (!personnage.getInventory().getInventory().isEmpty()) {
                System.out.println("Voicie ton inventaire : " + personnage.getInventory().toString());
                System.out.println("Selectionne l'id de l'item avec lequel tu ve interagir !\nTape 0 pour sortir de l'inventaire");
                int idItem = sc.nextInt() - 1;

                if (idItem != -1 && idItem < personnage.getInventory().getInventory().size()) {
                    System.out.println("Tu a selectioner : " + personnage.getInventory().getInventory().get(idItem));
                    inventoryOpen = personnage.getInventory().getInventory().get(idItem).itemInteract(personnage, idItem);
                } else {
                    inventoryOpen = false;
                    Thread.sleep(1000);
                }
            }
        }
    }

    private void inventoryFull() throws InterruptedException {
        System.out.println("Votre inventaire est plein, please remove ou utilise 1 items");
        openInventory();
    }
}
