package db;
import Personnage.Personnage;
import Personnage.Wizard;
import Personnage.Warrior;
import java.sql.*;
import java.util.Scanner;

public class DatabaseManagement {

    public Connection databaseConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "donpoulp";
        String password = "8kp457co99P+";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public void getHeroes() throws SQLException {

        Connection connection = databaseConnection();

        Statement statement = connection.createStatement();
        String query = "SELECT * FROM DonjonsEtDragons.Hero INNER JOIN DonjonsEtDragons.WeponsOrSpells ON DonjonsEtDragons.Hero.weaponOrSpell_id = DonjonsEtDragons.WeponsOrSpells.idWeponsOrSpells INNER JOIN DonjonsEtDragons.ShieldsOrPhilters ON shieldOrPhilter_id = idShieldsOrPhilters";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String idHero = resultSet.getString("idHero");
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");
            String health = resultSet.getString("health");
            String attackPower = resultSet.getString("attackPower");
            String weaponOrSpell = "name: " + resultSet.getString("WeponsOrSpells.name") + ", type: " + resultSet.getString("WeponsOrSpells.type") + ", powerBonus: " + resultSet.getString("WeponsOrSpells.powerBonus") + ", lvl: " + resultSet.getString("WeponsOrSpells.lvl");
            String shieldOrPhilter = "name: " + resultSet.getString("ShieldsOrPhilters.name") + ", type: " + resultSet.getString("ShieldsOrPhilters.type") + ", powerBonus: " + resultSet.getString("ShieldsOrPhilters.defenseBonus") + ", lvl: " + resultSet.getString("ShieldsOrPhilters.lvl");

            System.out.println("Id: " + idHero + ", Name: " + name + ", Type: " + type + ", Health: " + health + ", attackPower: " + attackPower + ", {weaponOrSpell: " + weaponOrSpell + "}" + ", {shieldOrPhilter: " + shieldOrPhilter + "}");
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
                String shieldOrPhilter = "name: " + resultSet.getString("ShieldsOrPhilters.name") + ", type: " + resultSet.getString("ShieldsOrPhilters.type") + ", powerBonus: " + resultSet.getString("ShieldsOrPhilters.defenseBonus") + ", lvl: " + resultSet.getString("ShieldsOrPhilters.lvl");

                //System.out.println("Tu a choisie: Id: " + idHero + ", Name: " + name + ", Type: " + type + ", Health: " + health + ", attackPower: " + attackPower + ", {weaponOrSpell: " + weaponOrSpell + "}" + ", {shieldOrPhilter: " + shieldOrPhilter + "}");
                if (resultSet.getInt("ShieldsOrPhilters.idShieldsOrPhilters") == 3){
                    selectShieldOrPhilter = "2";
                }else if (resultSet.getInt("ShieldsOrPhilters.idShieldsOrPhilters") == 4){
                    selectShieldOrPhilter = "1";
                }else {
                    selectShieldOrPhilter = resultSet.getString("ShieldsOrPhilters.idShieldsOrPhilters");
                }
                if (resultSet.getInt("WeponsOrSpells.idWeponsOrSpells") == 3){
                    selectWeaponOrSpell = "2";
                } else if (resultSet.getInt("WeponsOrSpells.idWeponsOrSpells") == 4) {
                    selectWeaponOrSpell = "1";
                }else {
                    selectWeaponOrSpell = resultSet.getString("WeponsOrSpells.idWeponsOrSpells");
                }
                infosPlayer = new String[]{name, selectWeaponOrSpell, selectShieldOrPhilter, type};
            }
        return  infosPlayer;
    }

    public void createHero(Personnage personnage) throws SQLException {
        Connection connection = databaseConnection();

        try{
            String name = personnage.getName();
            String type = personnage.getType();

            if (personnage.getType().equals("Wizard")){
                int health = ((Wizard)personnage).getHealth();
                int attackPower = ((Wizard)personnage).getAttackForce();

                String spellName = ((Wizard)personnage).getSpell().getName();
                if (spellName.equals("FireBall")){
                    spellName = "1";
                } else if (spellName.equals("IceBold")) {
                    spellName = "2";
                }

                String philterName = ((Wizard)personnage).getPhilter().getName();
                if (philterName.equals("HealPotion")){
                    philterName = "1";
                } else if (philterName.equals("MagicShield")) {
                    philterName = "2";
                }

                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DonjonsEtDragons.Hero(name, type, health, attackPower, weaponOrSpell_id, shieldOrPhilter_id) VALUES(?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, type);
                preparedStatement.setInt(3, health);
                preparedStatement.setInt(4, attackPower);
                preparedStatement.setString(5, spellName);
                preparedStatement.setString(6, philterName);

                preparedStatement.executeUpdate();

            } else if (personnage.getType().equals("Warrior")) {
                int health = ((Warrior)personnage).getHealth();
                int attackPower = ((Warrior)personnage).getAttackForce();

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

                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DonjonsEtDragons.Hero(name, type, health, attackPower, weaponOrSpell_id, shieldOrPhilter_id) VALUES(?, ?, ?, ?, ?, ?);");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, type);
                preparedStatement.setInt(3, health);
                preparedStatement.setInt(4, attackPower);
                preparedStatement.setString(5, weaponName);
                preparedStatement.setString(6, shieldName);

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
            String powerBonus = resultSet.getString("defenseBonus");
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
}
