package GameRule;
import Equipement.Philters.Philter;
import Equipement.Philters.SpecialCasePhilters.LittleHealthPotion;
import Equipement.Shields.Shield;
import Equipement.Spells.Spell;
import Equipement.Weapons.Weapon;
import Execption.PersonnageOffStageException;
import GameRule.Board.Board;
import GameRule.Board.Case;
import GameRule.Board.CaseEmpty;
import Monster.*;
import Personnage.Inventory.Items;
import Personnage.Personnage;
import java.lang.InterruptedException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Personnage.Wizard;
import Personnage.Warrior;
import db.DatabaseManagement;

public class Game {
    Board board;
    Personnage personnage;
    int position;

    static String z = Character.toString(0x2694);
    static String y = Character.toString(0x1F332);
    static String i = Character.toString(0x1F4A6);
    static String k = Character.toString(0x1F334);
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[30m";

    public Game(Personnage personnage) {
        this.board = new Board(63);
        this.personnage = personnage;
    }

    public Game(){

    }

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
        return "Game{" +
                "board=" + board +
                ", personnage=" + personnage +
                '}';
    }

    public void play() throws InterruptedException, PersonnageOffStageException, SQLException {
        Board board = new Board(63);
        ArrayList<Case> getBoard = board.getBoard();
        DatabaseManagement dbm = new DatabaseManagement();

        boolean green = false;
        boolean blue = false;
        boolean yellow = false;
        //ArrayList<Case> caseArrayList = new ArrayList<Case>();

        int position = 0;
        /// define the range of my dé ///
        int maxRange = 6;
        int minRange = 1;
        int range = maxRange - minRange + 1;

        System.out.println(ANSI_RESET);
        System.out.println("\n*********************  Comment jouer ?  *************************");
        System.out.println("\nAppuyer sur entrée pour jouer les tours\n\nAppuyer sur i pour ouvrire l'inventaire a n'importe quel moment\n\nTape save dans la console pour sauvegarder et quitter la partie\n\n" + board + "\n");
        System.out.println("*****************************************************************");
        while (position != getBoard.size()) {   /// Boucle qui tourne TANT QUE la position du joueur n'est pas égale à la fin du plateau
            String playRound = new Scanner(System.in).nextLine();

            int dé = (int) (Math.random() * range) + minRange;  /// on génère un chiffre aleatoire de 1 a 6
            position = position + dé;   /// on incremente la position du personnage avec le lancé de dé pour le faire avancer sur le plateau/// On Attend que l'utilisateur appuie sur une touche du clavier pour passer a la suite ( simule de l'interaction )

            if (personnage.getInventory().getInventory().size() > personnage.getInventory().getMaxSize()){
                inventoryFull();
            }
            if (playRound.equals("i") || playRound.equals("inventaire")) {
                if (!personnage.getInventory().getInventory().isEmpty()) {
                    openInventory();
                }else {
                    System.out.println("Inventaire vide !");
                }
            } else if (playRound.equals("save") || playRound.equals("SAVE") || playRound.equals("Save")) {
                dbm.modifyPersonnage(dbm.getHeroByName(personnage.getName()), personnage);
                dbm.createSaveGame(dbm.getHeroByName(personnage.getName()) , getBoard, position);
                break;
            }
            if (position < 0 || position > getBoard.size()) {     /// On vérifie que le personnage ne sort pas du plateau
                throw new PersonnageOffStageException("ERROR : votre personnage est sortie du plateau !!!\nPas de chance recommence du debut\nPS : Bouffon"); /// si il sort du plateau on renvoie une erreur personnaliser
            } else {
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
                System.out.println("Tu lance le dé et tu fais : " + dé);   /// on affiche au joueur le chiffre aleatoire générer qui represente sont lancée de dé
                System.out.println("Le personnage avance juqu'à la case : " + position);  /// on affiche au joueur ça position sur le plateau
                System.out.println("\nLa case contient : " + getBoard.get(position) + "\n");      /// on affiche au joueur le contenue de la case ou il tombe

                /// Ajout des regles de chaque case ///
                Case currentCase = board.getBoard().get(position); /// on attribut le contenue de la case actuelle du joueur a une variable
                checkCurrentCase(currentCase, position, range, minRange);  /// un lance une fonction déclarer plus bas qui va verifier s'il y a une action à lancer en regardans la case sur laquel ce trouve notre personnage
            }
        }   /// ICI la partie est fini
        Menu menu = new Menu();
        menu.reGame();  /// on lance la fonction regame pour proposer au joueur de relancer une partie
    }

    private boolean battle(Case currentCase) {
        Scanner sc = new Scanner(System.in);
        int countRound = 1;
        int PvBeforeBattle = personnage.getHealth();

        System.out.println(z + z + " Tu entre en combat ! " + z + z);

        while (personnage.getHealth() > 0 && ((Monster) currentCase).getHealth() > 0) {
            System.out.println("\nTu peut te battre comme un homme ou fuir comme un lache !");
            System.out.println("\nTape 1 pour te BATTRE !\nTape 2 pour fuir comme une lopsa !");
            int userChoice = sc.nextInt();
            if (userChoice == 1) {
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
                                userChoice = sc.nextInt();
                                if (userChoice == 1) {
                                    openInventory();
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
            } else if (userChoice == 2) {
                return false;
            }
        }
        return true;
    }


    private void checkCurrentCase(Case currentCase, int position, int range, int minRange) throws PersonnageOffStageException {
        Scanner sc = new Scanner(System.in);
        if (currentCase instanceof Weapon) {
            if (personnage instanceof Warrior) {
                System.out.println("Votre personnage possède déja : " + ((Warrior) personnage).getWeapons());
                System.out.println("\nTapez 1 pour vous équipez de la nouvelle arme\nTapez 2 pour gardez votre ancienne et stocker celle-ci dans l'inventaire\nTapez 3 pour jeter celle que vous venez de trouver");
                int userChoice = sc.nextInt();
                if (userChoice == 1) {
                    personnage.getInventory().addItem((Items) ((Warrior) personnage).getWeapons());
                    ((Warrior) personnage).setWeapon((Weapon) currentCase);
                    System.out.println("Nouvelle arme équiper ! L'ancienne été transférer dans l'inventaire");
                    System.out.println("\nAppuie sur entrée pour continuer");
                }
                if (userChoice == 2) {
                    personnage.getInventory().addItem((Items) currentCase);
                    System.out.println("Arme ajouter a l'inventaire ! voicie votre inventaire actuel : " + personnage.getInventory());
                    System.out.println("\nAppuie sur entrée pour continuer");
                }
                //personnage.setAttackForce(personnage.getAttackForce() + ((Weapon) currentCase).getPowerBonus());
                //System.out.println("L'attack de votre personnage a été modifier il a maintenant : " + personnage.getAttackForce() + "\n");
            }
        } else if (currentCase instanceof Spell) {
            if (personnage instanceof Wizard) {
                System.out.println("Votre personnage possède déja : " + ((Wizard) personnage).getSpell());
                System.out.println("\nTapez 1 pour vous équipez de la nouvelle arme\nTapez 2 pour gardez votre ancienne et stocker celle-ci dans l'inventaire\nTapez 3 pour jeter celle que vous venez de trouver");
                int userChoice = sc.nextInt();
                if (userChoice == 1) {
                    personnage.getInventory().addItem((Items) ((Wizard) personnage).getSpell());
                    ((Wizard) personnage).setSpell((Spell) currentCase);
                    System.out.println("Nouveau Sort équiper ! L'ancienne été transférer dans l'inventaire");
                    System.out.println("\nAppuie sur entrée pour continuer");
                }
                if (userChoice == 2) {
                    personnage.getInventory().addItem((Items) currentCase);
                    System.out.println("Sort ajouter a l'inventaire ! voicie votre inventaire actuel : " + personnage.getInventory());
                    System.out.println("\nAppuie sur entrée pour continuer");
                }
                //personnage.setAttackForce(personnage.getAttackForce() + ((Spell) currentCase).getPowerBonus());
                //System.out.println("La puissance magique de votre personnage a été modifier il a maintenant : " + personnage.getAttackForce() + "\n");
            }
        } else if (currentCase instanceof Shield) {
            if (personnage instanceof Warrior) {
                System.out.println("Votre personnage possède déja : " + ((Warrior) personnage).getShield());
                System.out.println("\nTapez 1 pour vous équipez de la nouvelle arme\nTapez 2 pour gardez votre ancienne et stocker celle-ci dans l'inventaire\nTapez 3 pour jeter celle que vous venez de trouver");
                int userChoice = sc.nextInt();
                if (userChoice == 1) {
                    personnage.getInventory().addItem((Items) ((Warrior) personnage).getShield());
                    ((Warrior) personnage).setShield((Shield) currentCase);
                    System.out.println("Nouveau bouclier équiper ! L'ancienne été transférer dans l'inventaire");
                    System.out.println("\nAppuie sur entrée pour continuer");
                }
                if (userChoice == 2) {
                    personnage.getInventory().addItem((Items) currentCase);
                    System.out.println("Shield ajouter a l'inventaire ! voicie votre inventaire actuel : " + personnage.getInventory());
                    System.out.println("\nAppuie sur entrée pour continuer");
                }
                //((Warrior) personnage).setDefenseBonus(((Warrior) personnage).getDefenseBonus() + ((Shield) currentCase).getDefenseBonus());
                //System.out.println("La defense de votre personnage a été modifier il a maintenant : " + ((Warrior) personnage).getDefenseBonus() + "\n");
            }
        } else if (currentCase instanceof Philter) {
            System.out.println("Tu a actuellement : " + personnage.getHealth() + "/" + personnage.getMaxHealth() + " PV");
            System.out.println("Tape 1 pour la jeter");
            System.out.println("Tape 2 pour la stocker dans l'inventaire");
            if (personnage.getHealth() < personnage.getMaxHealth()) {
                System.out.println("Tape 3 pour boire la potion immediatement");
            }
            int userChoice = sc.nextInt();
            if (userChoice == 3) {
                if (personnage.getHealth() < personnage.getMaxHealth()) {
                    if (personnage.getHealth() + ((Philter) currentCase).getLifePoint() > personnage.getMaxHealth()) {
                        personnage.setHealth(personnage.getMaxHealth());
                    }else {
                        personnage.setHealth(personnage.getHealth() + ((Philter) currentCase).getLifePoint());
                    }
                    System.out.println("La vie de votre personnage a été modifier il a maintenant : " + personnage.getHealth() + "\n");
                    System.out.println("\nAppuie sur entrée pour continuer");
                }
            } else if (userChoice == 2) {
                personnage.getInventory().addItem((Items) currentCase);
                System.out.println("Potion ajouter a l'inventaire ! voicie votre inventaire actuel : " + personnage.getInventory());
                System.out.println("\nAppuie sur entrée pour continuer");
            }
        } else if (currentCase instanceof Monster) {
            if (!battle(currentCase)) {
                int battleLoose = (int) (Math.random() * range) + minRange;
                if (position - battleLoose >= 0) {
                    position = position - battleLoose;
                    currentCase = board.getBoard().get(position);
                    System.out.println("position sur le plateau : " + position);
                    System.out.println("la case contient : " + board.getBoard().get(position) + "\n");
                    checkCurrentCase(currentCase, position, range, minRange);
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

    private void openInventory() {
        Scanner sc = new Scanner(System.in);
        if (!personnage.getInventory().getInventory().isEmpty()) {
            System.out.println("Voicie ton inventaire : " + personnage.getInventory().toString());
            System.out.println("Selectionne l'id de l'item avec lequel tu ve interagir !");
            int idItem = sc.nextInt()-1;

            System.out.println("Tu a selectioner : " + personnage.getInventory().getInventory().get(idItem));
            if (personnage.getInventory().getInventory().get(idItem) instanceof Weapon || personnage.getInventory().getInventory().get(idItem) instanceof Shield || personnage.getInventory().getInventory().get(idItem) instanceof Spell) {
                System.out.println("\nTape 1 pour équipé l'items selectionner\nTape 2 pour le supprimer");
                int userChoice = sc.nextInt();
                if (userChoice == 1) {
                    if (personnage.getInventory().getInventory().get(idItem) instanceof Weapon) {
                        personnage.getInventory().addItem((Items) ((Warrior) personnage).getWeapons());
                        ((Warrior) personnage).setWeapon((Weapon) personnage.getInventory().getInventory().get(idItem));
                        personnage.getInventory().getInventory().remove(idItem);
                        System.out.println("Tu t'es équipé de : " + ((Warrior) personnage).getWeapons());
                        System.out.println("T'on ancienne items à été envoyer dans l'inventaire !" + "\n");
                    } else if (personnage.getInventory().getInventory().get(idItem) instanceof Shield) {
                        personnage.getInventory().addItem((Items) ((Warrior) personnage).getShield());
                        ((Warrior) personnage).setShield((Shield) personnage.getInventory().getInventory().get(idItem));
                        personnage.getInventory().getInventory().remove(idItem);
                        System.out.println("Tu t'es équipé de : " + ((Warrior) personnage).getShield());
                        System.out.println("T'on ancienne items à été envoyer dans l'inventaire !" + "\n");
                    } else if (personnage.getInventory().getInventory().get(idItem) instanceof Spell) {
                        personnage.getInventory().addItem((Items) ((Wizard) personnage).getSpell());
                        ((Wizard) personnage).setSpell((Spell) personnage.getInventory().getInventory().get(idItem));
                        personnage.getInventory().getInventory().remove(idItem);
                        System.out.println("Tu t'es équipé de : " + ((Wizard) personnage).getSpell());
                        System.out.println("T'on ancienne items à été envoyer dans l'inventaire !" + "\n");
                    }
                } else if (userChoice == 2) {
                    personnage.getInventory().getInventory().remove(idItem);
                }
            } else if (personnage.getInventory().getInventory().get(idItem) instanceof Philter) {
                System.out.println("Tu a actuellement : " + personnage.getHealth() + "/" + personnage.getMaxHealth() + " PV\n");
                if (personnage.getHealth() < personnage.getMaxHealth()) {
                    System.out.println("Tape 1 pour boire la potion immediatement");
                }
                System.out.println("Tape 2 pour supprimer la potion de ton inventair");
                int userChoice = sc.nextInt();
                if (userChoice == 1) {
                    if (personnage.getHealth() < personnage.getMaxHealth()) {
                        if (personnage.getHealth() + ((Philter) personnage.getInventory().getInventory().get(idItem)).getLifePoint() > personnage.getMaxHealth()) {
                            personnage.setHealth(personnage.getMaxHealth());
                        }else {
                            personnage.setHealth(personnage.getHealth() + ((Philter) personnage.getInventory().getInventory().get(idItem)).getLifePoint());
                        }
                        System.out.println("La vie de votre personnage a été modifier il a maintenant : " + personnage.getHealth() + "\n");
                        System.out.println("Appuie sur entrée pour passer a la suite");
                    } else if (userChoice == 2) {
                        personnage.getInventory().getInventory().remove(idItem);
                    }
                }
            } else {
                System.out.println("Inventaire vide !!!");
            }
        }
    }

    private void inventoryFull(){
        System.out.println("Votre inventaire est plein, please remove ou utilise 1 items");
        openInventory();
    }
}
