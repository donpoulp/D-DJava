package Character;

public abstract class Character {

    String name;
    String type;

    /// constructeur ///
    public Character(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public Character(String name) {
        this.name = name;
    }

    public Character() {

    }

    /// getter ///
    public String getName() {return name;}
    public String getType() {return type;}

    /// setter ///
    public void setName(String name) {this.name = name;}
    public void setType(String type) {this.type = type;}

    @Override
    public String toString() {
        return "Character{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}