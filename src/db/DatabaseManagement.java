package db;
import GameRule.Board.Board;
import GameRule.Board.Case;
import Personnage.Inventory.Inventory;
import Personnage.Personnage;
import Personnage.Wizard;
import Personnage.Warrior;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;

public class DatabaseManagement {

    public Connection databaseConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "donpoulp";
        String password = "8kp457co99P+";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public void getHeroes() throws SQLException {

        Gson gson = new Gson();

        Connection connection = databaseConnection();

        Statement statement = connection.createStatement();
        String query = "SELECT * FROM DonjonsEtDragons.Hero INNER JOIN DonjonsEtDragons.WeponsOrSpells ON DonjonsEtDragons.Hero.weaponOrSpell_id = DonjonsEtDragons.WeponsOrSpells.idWeponsOrSpells INNER JOIN DonjonsEtDragons.ShieldsOrPhilters ON shieldOrPhilter_id = idShieldsOrPhilters";
        ResultSet resultSet = statement.executeQuery(query);
        System.out.printf("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %2s | %-10s | %-8s | %-6s | %-16s | %-60s | %-60s | %-30s |%n", "ID", "NOM", "Type", "Health", "Attaque de base", "Arme ou Sort", "Shield ou Philter", "Inventaire");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
        while (resultSet.next()) {
            if (resultSet.getInt("ShieldsOrPhilters.idShieldsOrPhilters") == 1 || resultSet.getInt("ShieldsOrPhilters.idShieldsOrPhilters") == 2 || resultSet.getInt("ShieldsOrPhilters.idShieldsOrPhilters") == 3 || resultSet.getInt("ShieldsOrPhilters.idShieldsOrPhilters") == 4) {
                if (resultSet.getInt("WeponsOrSpells.idWeponsOrSpells") == 1 || resultSet.getInt("WeponsOrSpells.idWeponsOrSpells") == 2 || resultSet.getInt("WeponsOrSpells.idWeponsOrSpells") == 3 || resultSet.getInt("WeponsOrSpells.idWeponsOrSpells") == 4) {
                    if (resultSet.getString("inventory").equals("[]")) {
                        String idHero = resultSet.getString("idHero");
                        String name = resultSet.getString("name");
                        String type = resultSet.getString("type");
                        String health = resultSet.getString("health");
                        String attackPower = resultSet.getString("attackPower");
                        String weaponOrSpell = "name: " + resultSet.getString("WeponsOrSpells.name") + ", type: " + resultSet.getString("WeponsOrSpells.type") + ", powerBonus: " + resultSet.getString("WeponsOrSpells.powerBonus") + ", lvl: " + resultSet.getString("WeponsOrSpells.lvl");
                        String shieldOrPhilter = "name: " + resultSet.getString("ShieldsOrPhilters.name") + ", type: " + resultSet.getString("ShieldsOrPhilters.type") + ", powerBonus: " + resultSet.getString("ShieldsOrPhilters.defenseBonusOrLifePoint") + ", lvl: " + resultSet.getString("ShieldsOrPhilters.lvl");
                        String inventory = resultSet.getString("Inventory");

                        System.out.printf("| %2s | %-10s | %-8s | %-6s | %-16s | %-60s | %-60s | %-30s |%n", idHero, name, type, health, attackPower, weaponOrSpell, shieldOrPhilter, inventory);
                    }
                }
            }
        }
        System.out.println();
        resultSet.close();
        statement.close();
        connection.close();
    }

    public String[] getHeroe(int id) throws SQLException {
        String []infosPlayer = new String[3];
        String selectWeaponOrSpell = "";
        String selectShieldOrPhilter = "";
        Connection connection = databaseConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM DonjonsEtDragons.Hero INNER JOIN DonjonsEtDragons.WeponsOrSpells ON DonjonsEtDragons.Hero.weaponOrSpell_id = DonjonsEtDragons.WeponsOrSpells.idWeponsOrSpells INNER JOIN DonjonsEtDragons.ShieldsOrPhilters ON shieldOrPhilter_id = idShieldsOrPhilters WHERE idHero = ? ;");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                        String idHero = resultSet.getString("idHero");
                        String name = resultSet.getString("name");
                        String type = resultSet.getString("type");
                        String health = resultSet.getString("health");
                        String attackPower = resultSet.getString("attackPower");
                        String weaponOrSpell = "name: " + resultSet.getString("WeponsOrSpells.name") + ", type: " + resultSet.getString("WeponsOrSpells.type") + ", powerBonus: " + resultSet.getString("WeponsOrSpells.powerBonus") + ", lvl: " + resultSet.getString("WeponsOrSpells.lvl");
                        String shieldOrPhilter = "name: " + resultSet.getString("ShieldsOrPhilters.name") + ", type: " + resultSet.getString("ShieldsOrPhilters.type") + ", powerBonus: " + resultSet.getString("ShieldsOrPhilters.defenseBonusOrLifePoint") + ", lvl: " + resultSet.getString("ShieldsOrPhilters.lvl");

                        //System.out.println("Tu a choisie: Id: " + idHero + ", Name: " + name + ", Type: " + type + ", Health: " + health + ", attackPower: " + attackPower + ", {weaponOrSpell: " + weaponOrSpell + "}" + ", {shieldOrPhilter: " + shieldOrPhilter + "}");
                        if (resultSet.getInt("ShieldsOrPhilters.idShieldsOrPhilters") == 3) {
                            selectShieldOrPhilter = "2";
                        } else if (resultSet.getInt("ShieldsOrPhilters.idShieldsOrPhilters") == 4) {
                            selectShieldOrPhilter = "1";
                        } else {
                            selectShieldOrPhilter = resultSet.getString("ShieldsOrPhilters.idShieldsOrPhilters");
                        }
                        if (resultSet.getInt("WeponsOrSpells.idWeponsOrSpells") == 3) {
                            selectWeaponOrSpell = "2";
                        } else if (resultSet.getInt("WeponsOrSpells.idWeponsOrSpells") == 4) {
                            selectWeaponOrSpell = "1";
                        } else {
                            selectWeaponOrSpell = resultSet.getString("WeponsOrSpells.idWeponsOrSpells");
                        }
                        infosPlayer = new String[]{name, selectWeaponOrSpell, selectShieldOrPhilter, type};
            }
        return  infosPlayer;
    }

    public int getHeroByName(String nom) throws SQLException {
        int idHero = 0;
        Connection connection = databaseConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM DonjonsEtDragons.Hero WHERE name = ? ;");
        statement.setString(1, nom);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            idHero = resultSet.getInt("idHero");
        }
        return  idHero;
    }

    public void createHero(Personnage personnage) throws SQLException {
        Connection connection = databaseConnection();

        Gson gson = new Gson();

        try{
            String name = personnage.getName();
            String type = personnage.getType();
            String inventory = gson.toJson(personnage.getInventory().getInventory());

            if (personnage.getType().equals("Wizard")){
                int health = personnage.getHealth();
                int attackPower = personnage.getAttackForce();

                String spellName = ((Wizard)personnage).getSpell().getName();
                if (spellName.equals("Fireball")){
                    spellName = "1";
                } else if (spellName.equals("IceBold")) {
                    spellName = "2";
                }

                String philterName = ((Wizard)personnage).getPhilter().getName();
                if (philterName.equals("HealPotion")){
                    philterName = "1";
                } else if (philterName.equals("MedicinalHerb")) {
                    philterName = "2";
                }

                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DonjonsEtDragons.Hero(name, type, health, attackPower, weaponOrSpell_id, shieldOrPhilter_id, inventory) VALUES(?, ?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, type);
                preparedStatement.setInt(3, health);
                preparedStatement.setInt(4, attackPower);
                preparedStatement.setString(5, spellName);
                preparedStatement.setString(6, philterName);
                preparedStatement.setString(7, inventory);

                preparedStatement.executeUpdate();

            } else if (personnage.getType().equals("Warrior")) {
                int health = personnage.getHealth();
                int attackPower = personnage.getAttackForce();

                String weaponName = ((Warrior)personnage).getWeapons().getName();
                if (weaponName.equals("WoodenSword")){
                    weaponName = "4";
                } else if (weaponName.equals("PaperSword")) {
                    weaponName = "3";
                }

                String shieldName = ((Warrior)personnage).getShield().getName();
                if (shieldName.equals("WoodenShield")){
                    shieldName = "4";
                } else if (shieldName.equals("PaperShield")) {
                    shieldName = "3";
                }

                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DonjonsEtDragons.Hero(name, type, health, attackPower, weaponOrSpell_id, shieldOrPhilter_id, inventory) VALUES(?, ?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, type);
                preparedStatement.setInt(3, health);
                preparedStatement.setInt(4, attackPower);
                preparedStatement.setString(5, weaponName);
                preparedStatement.setString(6, shieldName);
                preparedStatement.setString(7, inventory);

                preparedStatement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void editHero(Personnage personnage, int idPerso) throws SQLException, InterruptedException {
        int weaponOrSpell = 0;
        int shieldOrPhilter = 0;

        Scanner sc = new Scanner(System.in);

        Connection connection = databaseConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE DonjonsEtDragons.Hero SET name = ?, weaponOrSpell_id = ?, shieldOrPhilter_id = ? WHERE idHero = ?");

        System.out.println("le nom actuel de votre personnage est : " + personnage.getName() + ", Tapez un nouveau nom pour le modifier : ");
        String name = sc.nextLine();

        if (personnage.getType().equals("Wizard")){
            System.out.println("\nle sort actuel de votre personnage est : " + ((Wizard)personnage).getSpell() + "\n");
            getWeaponOrSpell(personnage.getType());
            System.out.println("\nTapez l'id du sort que vous voulez equipez a votre personnage");
            weaponOrSpell = sc.nextInt();

            System.out.println("\nle philtre actuel de votre personnage est : " + ((Wizard)personnage).getPhilter() + "\n");
            getShieldsOrSpells(personnage.getType());
            System.out.println("\nTapez l'id du moyen de defense que vous voulez equipez a votre personnage");
            shieldOrPhilter = sc.nextInt();

        } else if (personnage.getType().equals("Warrior")) {
            System.out.println("\nl'arme actuel de votre personnage est : " + ((Warrior)personnage).getWeapons() + "\n");
            getWeaponOrSpell(personnage.getType());
            System.out.println("\nTapez l'id de l'arme que vous voulez equipez a votre personnage");
            weaponOrSpell = sc.nextInt();

            System.out.println("\nle bouclier actuel de votre personnage est : " + ((Warrior)personnage).getShield() + "\n");
            getShieldsOrSpells(personnage.getType());
            System.out.println("\nTapez l'id du moyen de defense que vous voulez equipez a votre personnage");
            shieldOrPhilter = sc.nextInt();
        }

        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, weaponOrSpell);
        preparedStatement.setInt(3, shieldOrPhilter);
        preparedStatement.setInt(4, idPerso);

        preparedStatement.executeUpdate();
        System.out.println("Le personnage a bien été modifier, Retour au menu Principale\n\n");
        Thread.sleep(1000);
    }

    public void getWeaponOrSpell(String personnageType) throws SQLException {
        Connection connection = databaseConnection();
        String type = "";

        if (personnageType.equals("Wizard")){
            type = "Spell";
        }else if (personnageType.equals("Warrior")){
            type = "Sword";
        }

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM DonjonsEtDragons.WeponsOrSpells WHERE type = ?");
        statement.setString(1, type);
        ResultSet resultSet = statement.executeQuery();
        System.out.println("Liste des arme disponible pour votre personnage :");
        while (resultSet.next()) {
            String idWeaponOrSpell = resultSet.getString("idWeponsOrSpells");
            String name = resultSet.getString("name");
            String powerBonus = resultSet.getString("powerBonus");
            String lvl = resultSet.getString("lvl");

            System.out.println("Id: " + idWeaponOrSpell + ", Name: " + name + ", powerBonus: " + powerBonus + ", lvl: " + lvl);
        }
    }

    public void getShieldsOrSpells(String personnageType) throws SQLException {
        Connection connection = databaseConnection();
        String type = "";

        if (personnageType.equals("Wizard")){
            type = "Philter";
        }else if (personnageType.equals("Warrior")){
            type = "Shield";
        }

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM DonjonsEtDragons.ShieldsOrPhilters WHERE type = ?");
        statement.setString(1, type);
        ResultSet resultSet = statement.executeQuery();
        System.out.println("Liste des moyen de defendse disponible pour votre personnage :");
        while (resultSet.next()) {
            String idWeaponOrSpell = resultSet.getString("idShieldsOrPhilters");
            String name = resultSet.getString("name");
            String powerBonus = resultSet.getString("defenseBonusOrLifePoint");
            String lvl = resultSet.getString("lvl");

            System.out.println("Id: " + idWeaponOrSpell + ", Name: " + name + ", powerBonus: " + powerBonus + ", lvl: " + lvl);
        }
    }

    public void deletePersonnage(int id) throws SQLException, InterruptedException {
        Connection connection = databaseConnection();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM DonjonsEtDragons.Hero WHERE idHero = ?");
        statement.setInt(1, id);
        statement.executeUpdate();

        System.out.println("Le personnage a bien été supprimer, retour au menu principal\n\n");
        Thread.sleep(1000);
    }

    public void modifyPersonnage(int id, Personnage personnage) throws SQLException, InterruptedException {
        Connection connection = databaseConnection();
        Gson gson = new Gson();
        int idWeaponOrSpell = 0;
        int idShieldOrSpell = 0;
        String inventory = gson.toJson(personnage.getInventory().getInventory());

        PreparedStatement statement = connection.prepareStatement("UPDATE DonjonsEtDragons.Hero SET health = ?, weaponOrSpell_id = ?, shieldOrPhilter_id = ?, inventory = ? WHERE idHero = ?");

        if (personnage instanceof Warrior){
            if (((Warrior) personnage).getWeapons().getName().equals("PaperSword")){
                idWeaponOrSpell = 3;
            } else if (((Warrior) personnage).getWeapons().getName().equals("WoodenSword")) {
                idWeaponOrSpell = 4;
            } else if (((Warrior) personnage).getWeapons().getName().equals("GoldSword")) {
                idWeaponOrSpell = 7;
            } else if (((Warrior) personnage).getWeapons().getName().equals("LépéeNice")) {
                idWeaponOrSpell = 8;
            }
            if (((Warrior) personnage).getShield().getName().equals("PaperShield")){
                idShieldOrSpell = 3;
            } else if (((Warrior) personnage).getShield().getName().equals("WoodenShield")) {
                idShieldOrSpell = 4;
            } else if (((Warrior) personnage).getShield().getName().equals("GoldShield")) {
                idShieldOrSpell = 7;
            } else if (((Warrior) personnage).getShield().getName().equals("IronShield")) {
                idShieldOrSpell = 8;
            }
        } else if (personnage instanceof Wizard) {
            if (((Wizard) personnage).getSpell().getName().equals("Fireball")){
                idWeaponOrSpell = 1;
            } else if (((Wizard) personnage).getSpell().getName().equals("IceBold")) {
                idWeaponOrSpell = 2;
            } else if (((Wizard) personnage).getSpell().getName().equals("LightningStrike")) {
                idWeaponOrSpell = 5;
            } else if (((Wizard) personnage).getSpell().getName().equals("SupremeFireBall")) {
                idWeaponOrSpell = 6;
            }
            if (((Wizard) personnage).getPhilter().getName().equals("HealPotion")){
                idShieldOrSpell = 1;
            } else if (((Wizard) personnage).getPhilter().getName().equals("MedicinalHerb")) {
                idShieldOrSpell = 2;
            } else if (((Wizard) personnage).getPhilter().getName().equals("BigHealthPotion")) {
                idShieldOrSpell = 5;
            } else if (((Wizard) personnage).getPhilter().getName().equals("LittleHealthPotion")) {
                idShieldOrSpell = 6;
            }
        }

        statement.setInt(1, personnage.getHealth());
        statement.setInt(2, idWeaponOrSpell);
        statement.setInt(3, idShieldOrSpell);
        statement.setString(4, inventory);
        statement.setInt(5, id);

        statement.executeUpdate();
        System.out.println("Personnage sauvegarder !");
    }

    public void createSaveGame(int idHero, ArrayList<Case> board, int positionHeroInBoard) throws SQLException {
        Connection connection = databaseConnection();

        Gson gson = new Gson();
        String stringBoard = gson.toJson(board);
        stringBoard = "{board :" + stringBoard + "}";


        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DonjonsEtDragons.SaveGame(idHero, heroPosition_inBoard, board) VALUES(?, ?, ?);");

        preparedStatement.setInt(1, idHero);
        preparedStatement.setInt(2, positionHeroInBoard);
        preparedStatement.setString(3, stringBoard);

        preparedStatement.executeUpdate();
        System.out.println("La partie a bien été sauvegarder");
    }

    public void getSaveGame() throws SQLException {
        Connection connection = databaseConnection();

        Statement statement = connection.createStatement();
        String query = "SELECT * FROM DonjonsEtDragons.SaveGame INNER JOIN DonjonsEtDragons.Hero ON DonjonsEtDragons.SaveGame.idHero = DonjonsEtDragons.Hero.idHero INNER JOIN DonjonsEtDragons.WeponsOrSpells ON DonjonsEtDragons.Hero.weaponOrSpell_id = DonjonsEtDragons.WeponsOrSpells.idWeponsOrSpells INNER JOIN DonjonsEtDragons.ShieldsOrPhilters ON shieldOrPhilter_id = idShieldsOrPhilters";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int idSaveGame = resultSet.getInt("idSaveGame");
            int positionHeroOnBoard = resultSet.getInt("heroPosition_inBoard");
            String board = resultSet.getString("board");
            String idHero = resultSet.getString("idHero");
            String typeHero = resultSet.getString("Hero.type");
            String nameHero = resultSet.getString("Hero.name");
            int healthHero = resultSet.getInt("Hero.health");
            int attackPowerHero = resultSet.getInt("Hero.attackPower");
            String weaponOrSpell = "name: " + resultSet.getString("WeponsOrSpells.name") + ", type: " + resultSet.getString("WeponsOrSpells.type") + ", powerBonus: " + resultSet.getString("WeponsOrSpells.powerBonus") + ", lvl: " + resultSet.getString("WeponsOrSpells.lvl");
            String shieldOrPhilter = "name: " + resultSet.getString("ShieldsOrPhilters.name") + ", type: " + resultSet.getString("ShieldsOrPhilters.type") + ", powerBonus: " + resultSet.getString("ShieldsOrPhilters.defenseBonusOrLifePoint") + ", lvl: " + resultSet.getString("ShieldsOrPhilters.lvl");
            String inventory = resultSet.getString("Inventory");

            System.out.println(idSaveGame + " " + positionHeroOnBoard + " " + idHero + " " + typeHero + " " + nameHero + " " + healthHero + " " + attackPowerHero + " " + weaponOrSpell + " " + shieldOrPhilter + " " +inventory + " " + board);
        }
    }

    public String[] getOneSaveGame(int id) throws SQLException {
        Connection connection = databaseConnection();
        String []savedGame = new String[3];

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM DonjonsEtDragons.SaveGame INNER JOIN DonjonsEtDragons.Hero ON DonjonsEtDragons.SaveGame.idHero = DonjonsEtDragons.Hero.idHero INNER JOIN DonjonsEtDragons.WeponsOrSpells ON DonjonsEtDragons.Hero.weaponOrSpell_id = DonjonsEtDragons.WeponsOrSpells.idWeponsOrSpells INNER JOIN DonjonsEtDragons.ShieldsOrPhilters ON shieldOrPhilter_id = idShieldsOrPhilters WHERE idSaveGame = ?");
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int idSaveGame = resultSet.getInt("idSaveGame");
            int positionHeroOnBoard = resultSet.getInt("heroPosition_inBoard");
            String board = resultSet.getString("board");
            String idHero = resultSet.getString("idHero");
            String typeHero = resultSet.getString("Hero.type");
            String nameHero = resultSet.getString("Hero.name");
            int healthHero = resultSet.getInt("Hero.health");
            int attackPowerHero = resultSet.getInt("Hero.attackPower");
            String weaponOrSpell = "name: " + resultSet.getString("WeponsOrSpells.name") + ", type: " + resultSet.getString("WeponsOrSpells.type") + ", powerBonus: " + resultSet.getString("WeponsOrSpells.powerBonus") + ", lvl: " + resultSet.getString("WeponsOrSpells.lvl");
            String shieldOrPhilter = "name: " + resultSet.getString("ShieldsOrPhilters.name") + ", type: " + resultSet.getString("ShieldsOrPhilters.type") + ", powerBonus: " + resultSet.getString("ShieldsOrPhilters.defenseBonusOrLifePoint") + ", lvl: " + resultSet.getString("ShieldsOrPhilters.lvl");
            String inventory = resultSet.getString("Inventory");

            System.out.println(idSaveGame + " " + positionHeroOnBoard + " " + idHero + " " + typeHero + " " + nameHero + " " + healthHero + " " + attackPowerHero + " " + weaponOrSpell + " " + shieldOrPhilter + " " +inventory + " " + board);
            savedGame = new String[]{idHero, typeHero, String.valueOf(positionHeroOnBoard), board};
        }
        return savedGame;
    }
}
