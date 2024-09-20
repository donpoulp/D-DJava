package Character;
import Equipement.Shields.PaperShield;
import Equipement.Shields.Shield;
import Equipement.Shields.WoodenShield;
import Equipement.Spells.Fireball;
import Equipement.Spells.IceBold;
import Equipement.Spells.Spell;
import Equipement.Weapons.PaperSword;
import Equipement.Weapons.Weapon;
import Equipement.Weapons.WoodenSword;

public class Warrior extends Character {

    // attribut commun a tout les guerrier
    int health;
    int attackForce;
    Weapon weapon;
    Shield shield;

    public Warrior(String name, String weaponChoice, String shieldChoice) {
        super(name);
        this.health = 10;
        this.attackForce = 10;
        this.weapon = SelectWeapon(weaponChoice);
        this.shield = SelectShield(shieldChoice);
    }

    // getter
    public int getHealth(){return this.health;}
    public int getAttackForce(){return this.attackForce;}
    public Weapon getWeapons(){return this.weapon;}
    public Shield getShield(){return this.shield;}

    // setter
    public void setHealth(int health){this.health = 10;}
    public void setAttackForce(int attackForce){this.attackForce = 10;}
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
            return this.weapon = new WoodenSword("épée en bois");
        }if (inputUser.equals("2")){
            return this.weapon = new PaperSword("épée top tiers tkt");
        }
        return null;
    }

    public Shield SelectShield(String inputUser){
        if (inputUser.equals("1")){
            return this.shield = new WoodenShield("bouclier en bois");
        }if (inputUser.equals("2")){
            return this.shield = new PaperShield("bouclier top tiers tkt");
        }
        return null;
    }
}
