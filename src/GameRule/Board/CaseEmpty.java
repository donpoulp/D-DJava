package GameRule.Board;

public class CaseEmpty implements Case{
    String emoji = Character.toString(0x2753);

    @Override
    public String toString() {
        return emoji + " Case Vide";
    }
}
