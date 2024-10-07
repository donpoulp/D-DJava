package fr.campus.donjon.game.board.deserializer;

import fr.campus.donjon.equipement.philters.BasicPhilters.HealPotion;
import fr.campus.donjon.equipement.philters.BasicPhilters.MedicinalHerb;
import fr.campus.donjon.equipement.philters.SpecialCasePhilters.BigHealthPotion;
import fr.campus.donjon.equipement.philters.SpecialCasePhilters.LittleHealthPotion;
import fr.campus.donjon.equipement.shields.BasicShields.PaperShield;
import fr.campus.donjon.equipement.shields.BasicShields.WoodenShield;
import fr.campus.donjon.equipement.shields.SpecialCaseShields.GoldShield;
import fr.campus.donjon.equipement.shields.SpecialCaseShields.IronShield;
import fr.campus.donjon.equipement.spells.BasicSpells.Fireball;
import fr.campus.donjon.equipement.spells.BasicSpells.IceBold;
import fr.campus.donjon.equipement.spells.SpecialCaseSpells.LightningStrike;
import fr.campus.donjon.equipement.spells.SpecialCaseSpells.SupremeFireBall;
import fr.campus.donjon.equipement.weapons.BasicWeapons.PaperSword;
import fr.campus.donjon.equipement.weapons.BasicWeapons.WoodenSword;
import fr.campus.donjon.equipement.weapons.SpecialCaseWeapons.GoldSword;
import fr.campus.donjon.equipement.weapons.SpecialCaseWeapons.LépéeNice;
import fr.campus.donjon.personnage.inventory.Items;
import com.google.gson.*;

import java.lang.reflect.Type;

public class InventoryDeserializer implements JsonDeserializer<Items> {
    public Items deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();

        return switch (name) {
            case "HealPotion" -> new HealPotion();
            case "MedicinalHerb" -> new MedicinalHerb();
            case "LittleHealthPotion" -> new LittleHealthPotion();
            case "BigHealthPotion" -> new BigHealthPotion();
            case "IronShield" -> new IronShield();
            case "GoldShield" -> new GoldShield();
            case "PaperShield" -> new PaperShield();
            case "WoodenShield" -> new WoodenShield();
            case "LightningStrike" -> new LightningStrike();
            case "SupremeFireBall" -> new SupremeFireBall();
            case "Fireball" -> new Fireball();
            case "IceBold" -> new IceBold();
            case "GoldSword" -> new GoldSword();
            case "LépéeNice" -> new LépéeNice();
            case "PaperSword" -> new PaperSword();
            case "WoodenSword" -> new WoodenSword();
            default -> throw new JsonParseException("Unknown case type: " + name);
        };
    }
}
