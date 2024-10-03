package Equipement;

public abstract class DefensiveEquipement {

    String name;
    protected String type;

    public DefensiveEquipement(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {return name;}
    public String getType() {return type;}

    public void setName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}

    @Override
    public String toString() {
        return "DefensiveEquipement{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
