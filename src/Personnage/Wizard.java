package Personnage;

import Equipement.Philters.BasicPhilters.HealPotion;
import Equipement.Philters.BasicPhilters.MedicinalHerb;
import Equipement.Philters.Philter;
import Equipement.Spells.BasicSpells.Fireball;
import Equipement.Spells.BasicSpells.IceBold;
import Equipement.Spells.Spell;

public class Wizard extends Personnage {

    Spell spell;
    Philter philter;

    /// constructeur ///
    public Wizard(String name,String SpellChoice, String PhilterChoice){
        super(name, "Wizard");
        this.health = 1;
        this.attackForce = 20;
        this.spell = SelectSpell(SpellChoice);
        this.philter = SelectPhilter(PhilterChoice);
    }

    /// getter ///
    public Spell getSpell(){return this.spell;}
    public Philter getPhilter(){return this.philter;}

    /// setter ///
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
            return this.spell = new Fireball();
        }if (inputUser.equals("2")){
            return this.spell = new IceBold();
        }
        return null;
    }

    public Philter SelectPhilter(String inputUser){
        if (inputUser.equals("1")){
            return this.philter = new HealPotion();
        }if (inputUser.equals("2")){
            return this.philter = new MedicinalHerb();
        }
        return null;
    }
}
