package fr.campus.donjon.game;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.campus.donjon.exeption.PersonnageOffStageException;
import fr.campus.donjon.exeption.UserInputException;
import fr.campus.donjon.game.board.Board;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.game.board.deserializer.CaseDeserializer;
import fr.campus.donjon.game.board.deserializer.InventoryDeserializer;
import fr.campus.donjon.personnage.inventory.Inventory;
import fr.campus.donjon.personnage.inventory.Items;
import fr.campus.donjon.personnage.Personnage;
import fr.campus.donjon.personnage.Warrior;
import fr.campus.donjon.personnage.Wizard;
import com.google.gson.GsonBuilder;
import fr.campus.donjon.database.DatabaseManagement;
import com.google.gson.Gson;

import java.lang.InterruptedException;

public class Menu {
    Game game;

    static String emojiCastle = Character.toString(0x1F3F0);
    static String emojiDragon = Character.toString(0x1F409);
    public static final String ANSI_RESET = "\u001B[0m";

    private static final Scanner sc = new Scanner(System.in);
    private static boolean personnageCreate = false;
    private static final DatabaseManagement dbm = new DatabaseManagement();

    public void createPersonnage(){
        while(!personnageCreate) {
                System.out.println(ANSI_RESET);
                System.out.println("\n" + " " + emojiCastle + "  " + emojiDragon + "  " + "Bienvenue dans donjons et dragons" + "  " + emojiCastle + "  " + emojiDragon);
                System.out.println("\nTape 1 pour débuter une partie\nTape 2 pour reprendre une partie en cours");
            try {
                int userChoice = sc.nextInt();

                switch (userChoice) {
                    case 1:
                        InitializingNewGame();
                        break;
                    case 2:
                        InitializingSaveGame();
                        break;
                    default:
                        throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
                }
            }catch (InputMismatchException e){
                throw new InputMismatchException("Entre une valeur valide parmi celle proposer please !");
            }catch (UserInputException e){
                throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            }
        }
    }

    public void InitializingNewGame(){
        System.out.println("\nPour commencer une partie il vous faut un personnage\n\nTaper 1 pour crée un personnage\nTaper 2 pour selectionner un personnage déja existant");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                createNewPersonnage();
                break;
            case 2:
                selectPersonnageInBdd();
                break;
            default:
                throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
        }
    }

    public void createNewPersonnage(){
        System.out.println("Veuillez saisir un nom :");
        String playerName = sc.nextLine();

        System.out.println("Veuillez saisir une Classe entre Wizard et Warrior :\n tape 1 pour Wizard\n tape 2 pour Warrior");
        int playerChoiceClass = sc.nextInt();
        sc.nextLine();

        switch (playerChoiceClass){
            case 1:
                createNewWizard(playerName);
                break;
            case 2:
                createNewWarrior(playerName);
                break;
            default:
                throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
        }
    }

    public void createNewWarrior(String playerName){
        Personnage newWarrior = new Warrior(playerName, selectWarriorWeapon(), selectWarriorShield());
        System.out.println("creation reussie voicie votre personnage\n" + newWarrior);
        game = new Game(newWarrior);
        try {
            dbm.createHero(newWarrior);

            System.out.println("Bonne chance a toi " + newWarrior.getName() + " jeune Guerrier\n\n");

            personnageCreate = true;
            launchGame();
        } catch (SQLException | InterruptedException | PersonnageOffStageException e) {
            System.out.println(e.getMessage());
        }
    }

    public String selectWarriorWeapon(){
        System.out.println("Veuillez saisir une arme pour ton Warrior\n tape 1 pour Wooden Sword \n tape 2 Paper Sword");
        String playerChoiceWeapon = sc.nextLine();
        if (playerChoiceWeapon.equals("1") || playerChoiceWeapon.equals("2")) {
            return playerChoiceWeapon;
        } else {
            throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
        }
    }

    public String selectWarriorShield(){
        System.out.println("Veuillez saisir un bouclier pour ton Warrior\n tape 1 pour Wooden Shields \n tape 2 Paper Shields");
        String playerChoiceShield = sc.nextLine();

        if (playerChoiceShield.equals("1") || playerChoiceShield.equals("2")) {
            return playerChoiceShield;
        } else {
            throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
        }
    }

    public void createNewWizard(String playerName){
        Personnage newWizard = new Wizard(playerName, selectWizardSpell(), selectWizardPhilter());
        System.out.println("creation reussi voici votre personnage\n" + newWizard);
        game = new Game(newWizard);
        try {
            dbm.createHero(newWizard);

            System.out.println("Bonne chance a toi " + newWizard.getName() + " Jeune mage\n\n");

            personnageCreate = true;
            launchGame();
        } catch (InterruptedException | PersonnageOffStageException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String selectWizardSpell(){
        System.out.println("Veuillez saisir un sort pour ton Wizard\n tape 1 pour Fireball \n tape 2 Ice Bold");
        String playerChoiceSpell = sc.nextLine();
        if (playerChoiceSpell.equals("1") || playerChoiceSpell.equals("2")) {
            return playerChoiceSpell;
        } else {
            throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
        }
    }

    public String selectWizardPhilter(){
            System.out.println("Veuillez saisir un sort pour ton Wizard\n tape 1 pour Heal Potion \n tape 2 pour Herbe Medicinal");
            String playerChoicePhilter = sc.nextLine();
            if (playerChoicePhilter.equals("1") || playerChoicePhilter.equals("2")) {
                return playerChoicePhilter;
            } else {
                throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            }
    }

    public void selectPersonnageInBdd(){
        try {
            dbm.getHeroes();

            System.out.println("Tapez l'id du personnage a selectionner\nTape 0 pour retourné au Menu principal");
            int selectPerso = sc.nextInt();

            if (selectPerso == 0) {
                goMenu();
            }
            String[] newPerso = dbm.getHeroe(selectPerso);

            switch (newPerso[3]) {
                case "Warrior": selectWarriorInBdd(newPerso[0], newPerso[1], newPerso[2], selectPerso);
                    break;
                case "Wizard": selectWizardInBdd(newPerso[0], newPerso[1], newPerso[2], selectPerso);
                    break;
                default: throw new UserInputException("Personnage non valide !");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectWizardInBdd(String name, String spell, String philter, int idPerso) {
        try {
            Personnage newWizard = new Wizard(name, spell, philter);
            System.out.println("Selection reussie voicie votre personnage\n" + newWizard);
            game = new Game(newWizard);

            System.out.println("\nTapez 1 pour lancer la partie avec ce personnage\nTapez 2 pour modifier le personnage selectionner\nTapez 3 pour supprimer le personnage selectionner");
            int gameOrModify = sc.nextInt();
            sc.nextLine();

            switch (gameOrModify) {
                case 1:
                    launchGame();
                    personnageCreate = true;
                    break;
                case 2:
                    dbm.editHero(newWizard, idPerso);
                    break;
                case 3:
                    dbm.deletePersonnage(idPerso);
                    break;
                default:
                    throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            }
        }catch (InterruptedException | PersonnageOffStageException | SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void selectWarriorInBdd(String name, String weapon, String shield, int idPerso) {
        try {
            Personnage newWarrior = new Warrior(name, weapon, shield);
            System.out.println("Selection reussie voicie votre personnage : \n" + newWarrior + "\n");
            game = new Game(newWarrior);

            System.out.println("Tapez 1 pour lancer la partie avec ce personnage\nTapez 2 pour modifier le personnage selectionner\nTapez 3 pour supprimer le personnage selectionner");
            int gameOrModify = sc.nextInt();
            sc.nextLine();

            switch (gameOrModify) {
                case 1:
                    launchGame();
                    personnageCreate = true;
                    break;
                case 2:
                    dbm.editHero(newWarrior, idPerso);
                    break;
                case 3:
                    dbm.deletePersonnage(idPerso);
                    break;
                default:
                    throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            }
        }catch (InterruptedException | PersonnageOffStageException | SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void InitializingSaveGame(){
        try {
            dbm.getSaveGame();
            System.out.println("\nTapez l'Id Save de la partie à selectionner");
            int idSaveGame = sc.nextInt();

            String[] savedGame = dbm.getOneSaveGame(idSaveGame);

            System.out.println("\nTape 1 pour lancer cet partie\nTape 2 pour supprimer cet save");
            int userChoice = sc.nextInt();
            sc.nextLine();

            switch (userChoice){
                case 1: launchSaveGame(savedGame);
                    break;
                case 2: dbm.deleteSavedGame(idSaveGame);
                    break;
                default: throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            }
        } catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void launchSaveGame(String[] savedGame) {
        try {
            game = new Game();
            GsonBuilder gsonBuilder = new GsonBuilder();
            String[] heroSelect = dbm.getHeroe(Integer.parseInt(savedGame[0]));

            switch(savedGame[1]){
                case "Warrior": loadWarrior(heroSelect, savedGame, gsonBuilder);
                    break;
                case "Wizard":  loadWizard(heroSelect, savedGame, gsonBuilder);
                    break;
                default: throw new UserInputException("Personnage non valide !");
            }
        }catch (SQLException | InterruptedException | PersonnageOffStageException e){
            System.out.println(e.getMessage());
        }
    }

    public void loadWarrior(String[] heroSelect, String[] savedGame, GsonBuilder gsonBuilder) throws SQLException, InterruptedException, PersonnageOffStageException {
        Personnage loadPersonnage = new Warrior(heroSelect[0], heroSelect[1], heroSelect[2]);
        game.setPersonnage(loadPersonnage);

        gsonBuilder.registerTypeAdapter(Items.class, new InventoryDeserializer());
        Gson gsonI = gsonBuilder.create();

        Inventory deserializedInventory = gsonI.fromJson(savedGame[4], Inventory.class);
        loadPersonnage.setInventory(deserializedInventory);
        loadPersonnage.getInventory().setMaxSize(10);

        launchGameWithSaveParameter(savedGame, gsonBuilder);
    }

    public void loadWizard(String[] heroSelect, String[] savedGame, GsonBuilder gsonBuilder) throws SQLException, InterruptedException, PersonnageOffStageException {
        Personnage loadPersonnage = new Wizard(heroSelect[0], heroSelect[1], heroSelect[2]);
        game.setPersonnage(loadPersonnage);

        gsonBuilder.registerTypeAdapter(Items.class, new InventoryDeserializer());
        Gson gsonI = gsonBuilder.create();

        Inventory deserializedInventory = gsonI.fromJson(savedGame[4], Inventory.class);
        loadPersonnage.setInventory(deserializedInventory);
        loadPersonnage.getInventory().setMaxSize(10);

        launchGameWithSaveParameter(savedGame, gsonBuilder);
    }

    public void launchGameWithSaveParameter(String [] savedGame, GsonBuilder gsonBuilder) throws SQLException, InterruptedException, PersonnageOffStageException {
        game.setPosition(Integer.parseInt(savedGame[2]));

        String jsonBoardString = savedGame[3];

        gsonBuilder.registerTypeAdapter(Case.class, new CaseDeserializer());
        Gson gsonb = gsonBuilder.create();
        Board deserializedBoard = gsonb.fromJson(jsonBoardString, Board.class);

        game.setBoard(deserializedBoard);

        launchGame();
        personnageCreate = true;
    }

    public void launchGame() throws SQLException, InterruptedException, PersonnageOffStageException {
        System.out.println("\nTapez 1 pour lancer la partie\nTaper 2 pour quitter");
        String LaunchGame = sc.nextLine();

        switch (LaunchGame){
            case "1": game.play();
                break;
            case "2":
                break;
            default: throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
        }
    }

    public void reGame(){
        System.out.println("Tape 1 pour quitter !\nTape 2 pour relancer une partie");
        String playerChoiceReGame = sc.nextLine();
        if (playerChoiceReGame.equals("2")){
            System.out.println("Tape 1 pour jouer avec le même personnage\nTape 2 pour recrée un personnage ");
            String playerChoicePersonnage = sc.nextLine();
            if (playerChoicePersonnage.equals("1")){
                try{
                    game.play();
                }catch(InterruptedException | PersonnageOffStageException | SQLException e){
                    System.out.println(e);
                }
            } else if (playerChoicePersonnage.equals("2")) {
                createPersonnage();
            }else {
                throw new UserInputException("Entre une valeur valide parmi celle proposer please !");
            }
        }
    }

    public void goMenu() throws InterruptedException {
        Thread.sleep(1000);
        Menu menu = new Menu();
        menu.createPersonnage();
    }
}

