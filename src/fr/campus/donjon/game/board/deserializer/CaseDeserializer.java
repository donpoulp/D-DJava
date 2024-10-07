package fr.campus.donjon.game.board.deserializer;

import fr.campus.donjon.equipement.philters.SpecialCasePhilters.BigHealthPotion;
import fr.campus.donjon.equipement.philters.SpecialCasePhilters.LittleHealthPotion;
import fr.campus.donjon.equipement.shields.SpecialCaseShields.GoldShield;
import fr.campus.donjon.equipement.shields.SpecialCaseShields.IronShield;
import fr.campus.donjon.equipement.spells.SpecialCaseSpells.LightningStrike;
import fr.campus.donjon.equipement.spells.SpecialCaseSpells.SupremeFireBall;
import fr.campus.donjon.equipement.weapons.SpecialCaseWeapons.GoldSword;
import fr.campus.donjon.equipement.weapons.SpecialCaseWeapons.LépéeNice;
import fr.campus.donjon.game.board.Case;
import fr.campus.donjon.game.board.CaseEmpty;
import fr.campus.donjon.monster.Dragon;
import fr.campus.donjon.monster.Gobelin;
import fr.campus.donjon.monster.Sorcerer;
import com.google.gson.*;

import java.lang.reflect.Type;

public class CaseDeserializer implements JsonDeserializer<Case> {

    @Override
    public Case deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String name = jsonObject.get("name").getAsString(); // Retrieve the name field

        /// modify switch for : class.forname(name).newInstance();

        switch (name) {
            case "caseEmpty":
                return new CaseEmpty();
            case "Sorcerer":
                return new Sorcerer();
            case "Dragon":
                return new Dragon();
            case "Gobelin":
                return new Gobelin();
            case "LittleHealthPotion":
                return new LittleHealthPotion();
            case "BigHealthPotion":
                return new BigHealthPotion();
            case "IronShield":
                return new IronShield();
            case "GoldShield":
                return new GoldShield();
            case "LightningStrike":
                return new LightningStrike();
            case "SupremeFireBall":
                return new SupremeFireBall();
            case "GoldSword":
                return new GoldSword();
            case "LépéeNice":
                return new LépéeNice();
            default:
                throw new JsonParseException("Unknown case type: " + name);
        }
    }
}
