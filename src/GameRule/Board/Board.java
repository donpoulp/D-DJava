package GameRule.Board;

import Equipement.Philters.SpecialCasePhilters.BigHealthPotion;
import Equipement.Philters.SpecialCasePhilters.LittleHealthPotion;
import Equipement.Shields.SpecialCaseShields.GoldShield;
import Equipement.Shields.SpecialCaseShields.IronShield;
import Equipement.Spells.SpecialCaseSpells.LightningStrike;
import Equipement.Spells.SpecialCaseSpells.SupremeFireBall;
import Equipement.Weapons.SpecialCaseWeapons.GoldSword;
import Equipement.Weapons.SpecialCaseWeapons.LépéeNice;
import Monster.Dragon;
import Monster.Gobelin;
import Monster.Sorcerer;

import java.util.ArrayList;
import java.util.Arrays;

public class Board implements Case {
    ArrayList<Case> board;

    /// constructor ///
    public Board(int size) {
        this.board = new ArrayList<Case>(size);
        placeCaseOnBoard();
    }

    /// getters ///
    public ArrayList<Case> getBoard() {return board;}
    //public ArrayList<Case>[] getCases(Case c) {return board<c>;}

    /// setters ///
    public void setBoard(ArrayList<Case> board) {this.board = board;}

    /// toString ///
    @Override
    public String toString() {
        return "Board{" +
                "board=" + this.board +
                '}';
    }

    //public int length(){return board.size();}

    public void placeCaseOnBoard(){

        GoldSword goldSword = new GoldSword();
        LépéeNice lépéeNice = new LépéeNice();

        LightningStrike lightningStrike = new LightningStrike();
        SupremeFireBall supremeFireBall = new SupremeFireBall();

        GoldShield goldShield = new GoldShield();
        IronShield ironShield = new IronShield();


        BigHealthPotion bigHealthPotion = new BigHealthPotion();
        LittleHealthPotion littleHealthPotion = new LittleHealthPotion();

        Dragon dragon = new Dragon();
        Gobelin gobelin = new Gobelin();
        Sorcerer sorcerer = new Sorcerer();

        CaseEmpty caseEmpty = new CaseEmpty();

        Case[] randomTab = new Case[12];

        randomTab[0] = goldSword;
        randomTab[1] = lépéeNice;
        randomTab[2] = lightningStrike;
        randomTab[3] = supremeFireBall;
        randomTab[4] = goldShield;
        randomTab[5] = ironShield;
        randomTab[6] = bigHealthPotion;
        randomTab[7] = littleHealthPotion;
        randomTab[8] = dragon;
        randomTab[9] = gobelin;
        randomTab[10] = sorcerer;
        randomTab[11] = caseEmpty;

        int maxRange = 11;
        int minRange = 1;
        int range = maxRange - minRange + 1;

        for (int i = 0; i < 64; i++) {
            int RandomSelect = (int)(Math.random() * range)+ minRange;
                this.board.add(randomTab[RandomSelect]);
        }
        //System.out.println(Arrays.toString(board));
    }
}
