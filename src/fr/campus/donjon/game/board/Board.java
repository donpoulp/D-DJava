package fr.campus.donjon.game.board;

import fr.campus.donjon.equipement.philters.SpecialCasePhilters.BigHealthPotion;
import fr.campus.donjon.equipement.philters.SpecialCasePhilters.LittleHealthPotion;
import fr.campus.donjon.equipement.shields.SpecialCaseShields.GoldShield;
import fr.campus.donjon.equipement.shields.SpecialCaseShields.IronShield;
import fr.campus.donjon.equipement.spells.SpecialCaseSpells.LightningStrike;
import fr.campus.donjon.equipement.spells.SpecialCaseSpells.SupremeFireBall;
import fr.campus.donjon.equipement.weapons.SpecialCaseWeapons.GoldSword;
import fr.campus.donjon.equipement.weapons.SpecialCaseWeapons.LépéeNice;
import fr.campus.donjon.exeption.PersonnageOffStageException;
import fr.campus.donjon.monster.Dragon;
import fr.campus.donjon.monster.Gobelin;
import fr.campus.donjon.monster.Sorcerer;
import fr.campus.donjon.personnage.Personnage;

import java.util.ArrayList;

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
        int count = 0;

        StringBuilder boardString = new StringBuilder();
        for (Case c : board) {
            if (c instanceof Dragon){
                boardString.append(" | ").append(count + " ").append(((Dragon) c).getEmoji() + " ").append(((Dragon) c).getName()).append(" | ");
            }else if (c instanceof Sorcerer){
                boardString.append(" | ").append(count + " ").append(((Sorcerer) c).getEmoji() + " ").append(((Sorcerer) c).getName()).append(" | ");
            } else if (c instanceof Gobelin) {
                boardString.append(" | ").append(count + " ").append(((Gobelin) c).getEmoji() + " ").append(((Gobelin) c).getName()).append(" | ");
            }else if (c instanceof LittleHealthPotion){
                boardString.append(" | ").append(count + " ").append(((LittleHealthPotion) c).getEmoji() + " ").append(((LittleHealthPotion) c).getName()).append(" | ");
            }else if (c instanceof BigHealthPotion){
                boardString.append(" | ").append(count + " ").append(((BigHealthPotion) c).getEmoji() + " ").append(((BigHealthPotion) c).getName()).append(" | ");
            } else if (c instanceof SupremeFireBall) {
                boardString.append(" | ").append(count + " ").append(((SupremeFireBall) c).getEmoji() + " ").append(((SupremeFireBall) c).getName()).append(" | ");
            } else if (c instanceof LightningStrike) {
                boardString.append(" | ").append(count + " ").append(((LightningStrike) c).getEmoji() + " ").append(((LightningStrike) c).getName()).append(" | ");
            } else if (c instanceof GoldSword) {
                boardString.append(" | ").append(count + " ").append(((GoldSword) c).getEmoji() + " ").append(((GoldSword) c).getName()).append(" | ");
            } else if (c instanceof LépéeNice) {
                boardString.append(" | ").append(count + " ").append(((LépéeNice) c).getEmoji() + " ").append(((LépéeNice) c).getName()).append(" | ");
            } else if (c instanceof IronShield) {
                boardString.append(" | ").append(count + " ").append(((IronShield) c).getEmoji() + " ").append(((IronShield) c).getName()).append(" | ");
            } else if (c instanceof  GoldShield) {
                boardString.append(" | ").append(count + " ").append(((GoldShield) c).getEmoji() + " ").append(((GoldShield) c).getName()).append(" | ");
            } else if (c instanceof CaseEmpty) {
                boardString.append(" | ").append(count + " ").append(c).append(" | ");
            }
            count++;
        }
        return  "         -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                "Board : " + boardString + "\n" +
                "         -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
    }

    //public int length(){return board.size();}

    public void placeCaseOnBoard(){

        int maxRange = 13;
        int minRange = 1;
        int range = maxRange - minRange + 1;

        for (int i = 0; i < 64; i++) {

            Case[] randomTab = new Case[14];

            randomTab[0] = new GoldSword();
            randomTab[1] = new LépéeNice();
            randomTab[2] = new LightningStrike();
            randomTab[3] = new SupremeFireBall();
            randomTab[4] = new GoldShield();
            randomTab[5] = new IronShield();
            randomTab[6] = new BigHealthPotion();
            randomTab[7] = new LittleHealthPotion();
            randomTab[8] = new Dragon();
            randomTab[9] = new Gobelin();
            randomTab[10] = new Sorcerer();

            randomTab[11] = new CaseEmpty();
            randomTab[12] = new CaseEmpty();
            randomTab[13] = new CaseEmpty();

            int RandomSelect = (int)(Math.random() * range)+ minRange;
                this.board.add(i, randomTab[RandomSelect]);
        }
        //System.out.println(Arrays.toString(board));
    }

    @Override
    public void caseInteract(Personnage p, Case currentCase, int position, Board board) throws InterruptedException, PersonnageOffStageException {

    }
}
