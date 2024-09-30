package Personnage;
import Equipement.Shields.BasicShields.PaperShield;
import Equipement.Shields.Shield;
import Equipement.Shields.BasicShields.WoodenShield;
import Equipement.Weapons.BasicWeapons.PaperSword;
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
        this.attackForce = 5;
        this.defenseBonus = 2;
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
        return "Warrior{" +
                "name = '" + name +
                ", health = " + this.health +
                ", attackForce = " + this.attackForce +
                "}\n weapon = " + this.weapon +
                "\n shield = " + this.shield +
                '}';
    }

    public Weapon SelectWeapon(String inputUser){
        if (inputUser.equals("1")){
            return this.weapon = new WoodenSword();
        }if (inputUser.equals("2")){
            return this.weapon = new PaperSword();
        }
        return null;
    }

    public Shield SelectShield(String inputUser){
        if (inputUser.equals("1")){
            return this.shield = new WoodenShield();
        }if (inputUser.equals("2")){
            return this.shield = new PaperShield();
        }
        return null;
    }
}
