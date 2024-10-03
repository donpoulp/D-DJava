package Equipement;

public abstract class OffensiveEquipment {

    String name;
    protected String type;

    /// contructor ///
    public OffensiveEquipment(String name, String type) {
        this.name = name;
        this.type = type;
    }
    /// getters ///
    public String getName() {return name;}
    public String getType() {return type;}

    /// setters ///
    public void setName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}

    /// toString ///
    @Override
    public String toString() {
        return "OffensiveEquipment{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
