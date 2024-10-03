package Personnage;
import Equipement.Shields.BasicShields.PaperShield;
import Equipement.Shields.Shield;
import Equipement.Shields.BasicShields.WoodenShield;
import Equipement.Shields.SpecialCaseShields.GoldShield;
import Equipement.Shields.SpecialCaseShields.IronShield;
import Equipement.Weapons.BasicWeapons.PaperSword;
import Equipement.Weapons.SpecialCaseWeapons.GoldSword;
import Equipement.Weapons.SpecialCaseWeapons.LépéeNice;
import Equipement.Weapons.Weapon;
import Equipement.Weapons.BasicWeapons.WoodenSword;

public class Warrior extends Personnage {
    int defenseBonus;
    // attribut commun a tout les guerrier
    Weapon weapon;
    Shield shield;

    public Warrior(String name, String weaponChoice, String shieldChoice) {
        super(name, "Warrior");
        this.health = 10;
        this.maxHealth = 10;
        this.attackForce = 5;
        this.defenseBonus = 1;
        this.weapon = SelectWeapon(weaponChoice);
        this.shield = SelectShield(shieldChoice);
    }

    // getter
    public int getDefenseBonus() {return defenseBonus;}
    public Weapon getWeapons(){return this.weapon;}
    public Shield getShield(){return this.shield;}

    // setter
    public void setDefenseBonus(int defenseBonus) {this.defenseBonus = defenseBonus;}
    public void setWeapon(Weapon weapon){this.weapon = weapon;}
    public void setShield(Shield shield){this.shield = shield;}


    @Override
    public String toString() {
        return "\n****************************  Guerrier  *************************************" +
                "\n* Nom : " + name +
                "\n* Vie : " + this.health +
                "\n* Attaque de base : " + this.attackForce +
                "\n* Defense de base : " + this.defenseBonus +
                "\n* Arme : " + this.weapon +
                "\n* Shield : " + this.shield +
                "\n* " + this.inventory +
                "\n***************************************************************************";
    }

    public Weapon SelectWeapon(String inputUser){
        if (inputUser.equals("1")){
            return this.weapon = new WoodenSword();
        }if (inputUser.equals("2")){
            return this.weapon = new PaperSword();
        }if (inputUser.equals("7")){
            return this.weapon = new GoldSword();
        }if (inputUser.equals("8")){
            return this.weapon = new LépéeNice();
        }
        return null;
    }

    public Shield SelectShield(String inputUser){
        if (inputUser.equals("1")){
            return this.shield = new WoodenShield();
        }if (inputUser.equals("2")){
            return this.shield = new PaperShield();
        }if (inputUser.equals("7")){
            return this.shield = new GoldShield();
        }if (inputUser.equals("8")){
            return this.shield = new IronShield();
        }
        return null;
    }
}
