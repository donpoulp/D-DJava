package Character;

import Equipement.Philters.HealPotion;
import Equipement.Philters.MagicShield;
import Equipement.Philters.Philter;
import Equipement.Spells.Fireball;
import Equipement.Spells.IceBold;
import Equipement.Spells.Spell;

public class Wizard extends Character {

    int health;
    int attackForce;
    Spell spell;
    Philter philter;

    /// constructeur ///
    public Wizard(String name,String SpellChoice, String PhilterChoice){
        super(name);
        this.health = 1;
        this.attackForce = 20;
        this.spell = SelectSpell(SpellChoice);
        this.philter = SelectPhilter(PhilterChoice);
    }

    /// getter ///
    public int getHealth(){return this.health;}
    public int getAttackForce(){return this.attackForce;}
    public Spell getSpell(){return this.spell;}
    public Philter getPhilter(){return this.philter;}

    /// setter ///
    public void setHealth(int health){this.health = 1;}
    public void setAttackForce(int attackForce){this.attackForce = 20;}
    public void setSpell(Spell spell){this.spell = spell;}
    public void setPhilter(Philter philter){this.philter = philter;}

    @Override
    public String toString() {
        return "Wizard{" +
                "name = '" + name +
                ", health = " + this.health +
                ", attackForce = " + this.attackForce +
                "}\n spell = " + this.spell +
                "\n philter = " + this.philter +
                '}';
    }

    public Spell SelectSpell(String inputUser){
        if (inputUser.equals("1")){
            return this.spell = new Fireball("boule qui brule");
        }if (inputUser.equals("2")){
            return this.spell = new IceBold("boule qui fait froid");
        }
        return null;
    }

    public Philter SelectPhilter(String inputUser){
        if (inputUser.equals("1")){
            return this.philter = new HealPotion("Potion de vie");
        }if (inputUser.equals("2")){
            return this.philter = new MagicShield("Bouclier magic");
        }
        return null;
    }
}
