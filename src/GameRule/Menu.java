package GameRule;

import java.lang.invoke.StringConcatFactory;
import java.sql.SQLException;
import java.util.Scanner;

import Execption.PersonnageOffStageException;
import Personnage.Personnage;
import Personnage.Warrior;
import Personnage.Wizard;
import db.DatabaseManagement;

import java.lang.InterruptedException;

public class Menu {
    Game game;
    public void createPersonnage() {
        Scanner sc = new Scanner(System.in);
        Boolean personnageCreate = false;

        DatabaseManagement dbm = new DatabaseManagement();

        while(personnageCreate == false) {
            System.out.println("Bienvenue dans donjons et dragons !!\nPour commencer une partie il vous faut un personnage !\n\nTaper 1 pour crée un personnage\nTaper 2 pour selectionner un personnage déja existant");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.println("Veuillez saisir un nom :");
                String playerName = sc.nextLine();

                System.out.println("Veuillez saisir une Classe entre Wizard et Warrior :\n tape 1 pour Wizard\n tape 2 pour Warrior");
                int playerChoiceClass = sc.nextInt();
                sc.nextLine();

                if (playerChoiceClass == 1) {
                    System.out.println("Veuillez saisir un sort pour ton Wizard\n tape 1 pour Fireball \n tape 2 Ice Bold");
                    String playerChoiceSpell = sc.nextLine();
                    if (playerChoiceSpell.equals("1") || playerChoiceSpell.equals("2")) {
                        System.out.println("Veuillez saisir un sort pour ton Wizard\n tape 1 pour Heal Potion \n tape 2 Magic Shields");
                        String PlayerChoicePhilter = sc.nextLine();
                        if (PlayerChoicePhilter.equals("1") || PlayerChoicePhilter.equals("2")) {
                            Personnage newWizard = new Wizard(playerName, playerChoiceSpell, PlayerChoicePhilter);
                            System.out.println("creation reussie voicie votre personnage\n" + newWizard);
                            game = new Game(newWizard);
                            try {
                                dbm.createHero(newWizard);
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }

                            System.out.println("Bonne chance a toi " + newWizard.getName() + " Jeune mage\n\n");

                            personnageCreate = true;
                            laucnchGame();
                        } else {
                            System.out.println("error");
                        }
                    } else {
                        System.out.println("error");
                    }
                } else if (playerChoiceClass == 2) {
                    System.out.println("Veuillez saisir une arme pour ton Warrior\n tape 1 pour Wooden Sword \n tape 2 Paper Sword");
                    String playerChoiceWeapon = sc.nextLine();
                    if (playerChoiceWeapon.equals("1") || playerChoiceWeapon.equals("2")) {
                        System.out.println("Veuillez saisir un bouclier pour ton Warrior\n tape 1 pour Wooden Shields \n tape 2 Paper Shields");
                        String PlayerChoiceShield = sc.nextLine();
                        if (PlayerChoiceShield.equals("1") || PlayerChoiceShield.equals("2")) {
                            Personnage newWarrior = new Warrior(playerName, playerChoiceWeapon, PlayerChoiceShield);
                            System.out.println("creation reussie voicie votre personnage\n" + newWarrior);
                            game = new Game(newWarrior);
                            try {
                                dbm.createHero(newWarrior);
                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                            System.out.println("Bonne chance a toi " + newWarrior.getName() + " jeune Guerrier\n\n");

                            personnageCreate = true;
                            laucnchGame();
                        } else {
                            System.out.println("error");
                        }
                    } else {
                        System.out.println("error");
                    }
                } else {
                    System.out.println("error");
                }
            } else if (option == 2) {
                try {
                    dbm.getHeroes();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Tapez l'id du personnage a selectionner");
                int selectPerso = sc.nextInt();

                try {
                    String[] newPerso = dbm.getHeroe(selectPerso);
                    if (newPerso[3].equals("Warrior")){
                        Personnage newWarrior = new Warrior(newPerso[0], newPerso[1], newPerso[2]);
                        System.out.println("Selection reussie voicie votre personnage : \n" + newWarrior + "\n");
                        game = new Game(newWarrior);

                        System.out.println("Tapez 1 pour lancer la partie avec ce personnage\nTapez 2 pour modifier le personnage selectionner\nTapez 3 pour supprimer le personnage selectionner");
                        int gameOrModify = sc.nextInt();
                        if (gameOrModify == 1) {
                            laucnchGame();
                            personnageCreate = true;
                        } else if (gameOrModify == 2) {
                            modifyHero(newWarrior, selectPerso);
                        }else if (gameOrModify == 3) {
                            dbm.deletePersonnage(selectPerso);
                        }
                    } else if (newPerso[3].equals("Wizard")) {
                        Personnage newWizard = new Wizard(newPerso[0], newPerso[1], newPerso[2]);
                        System.out.println("Selection reussie voicie votre personnage\n" + newWizard);
                        game = new Game(newWizard);

                        System.out.println("\nTapez 1 pour lancer la partie avec ce personnage\nTapez 2 pour modifier le personnage selectionner\nTapez 3 pour supprimer le personnage selectionner");
                        int gameOrModify = sc.nextInt();
                        if (gameOrModify == 1) {
                            laucnchGame();
                            personnageCreate = true;
                        } else if (gameOrModify == 2) {
                            modifyHero(newWizard, selectPerso);
                        }else if (gameOrModify == 3) {
                            dbm.deletePersonnage(selectPerso);
                        }
                    }
                } catch (SQLException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void reGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tape 1 pour quitter !\nTape 2 pour relancer une partie");
        String playerChoiceReGame = sc.nextLine();
        if (playerChoiceReGame.equals("2")){
            System.out.println("Tape 1 pour jouer avec le même personnage\nTape 2 pour recrée un personnage ");
            String playerChoicePersonnage = sc.nextLine();
            if (playerChoicePersonnage.equals("1")){
                try{
                    game.play();
                }catch(InterruptedException | PersonnageOffStageException e){
                    System.out.println(e);
                }
            } else if (playerChoicePersonnage.equals("2")) {
                createPersonnage();
            }
        }
    }

    public void laucnchGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nTapez 1 pour lancer la partie\nTaper 2 pour quitter");
        String LaunchGame = sc.nextLine();
        if (LaunchGame.equals("1")) {
            boolean condition = false;
            while (!condition) {
                try {
                    game.play();
                    condition = true;
                } catch (InterruptedException | PersonnageOffStageException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void modifyHero(Personnage newPerso, int idPerso){
        Scanner sc = new Scanner(System.in);
        DatabaseManagement dbm = new DatabaseManagement();

        try {
            dbm.editHero(newPerso, idPerso);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

