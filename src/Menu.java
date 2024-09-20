import java.util.Objects;
import java.util.Scanner;
import Character.Warrior;
import Character.Wizard;
import GameRule.Game;

public class Menu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

           // while(player.equals("")){
            System.out.println("Veuillez saisir un nom :");
            String playerName = sc.nextLine();
            System.out.println("Veuillez saisir une Classe entre Wizard et Warrior :\n tape 1 pour Wizard\n tape 2 pour Warrior");
            String playerChoiceClass = sc.nextLine();

            if(playerChoiceClass.equals("1")){
                System.out.println("Veuillez saisir un sort pour ton Wizard\n tape 1 pour Fireball \n tape 2 Ice Bold");
                String playerChoiceSpell = sc.nextLine();
                System.out.println("Veuillez saisir un sort pour ton Wizard\n tape 1 pour Heal Potion \n tape 2 Magic Shields");
                String PlayerChoicePhilter = sc.nextLine();
                Wizard newWizard = new Wizard(playerName, playerChoiceSpell, PlayerChoicePhilter);
                System.out.println("creation reussie voicie votre personnage\n" + newWizard);

                new Game(newWizard);

            }else if(playerChoiceClass.equals("2")){
                System.out.println("Veuillez saisir une arme pour ton Warrior\n tape 1 pour Wooden Sword \n tape 2 Paper Sword");
                String playerChoiceWeapon = sc.nextLine();
                System.out.println("Veuillez saisir un bouclier pour ton Warrior\n tape 1 pour Wooden Shields \n tape 2 Paper Shields");
                String PlayerChoiceShield = sc.nextLine();
                Warrior newWarrior = new Warrior(playerName, playerChoiceWeapon, PlayerChoiceShield);
                System.out.println("creation reussie voicie votre personnage\n" + newWarrior);

                new Game(newWarrior);
            }else {
                System.out.println("error");
            }

            //}
    }
}
