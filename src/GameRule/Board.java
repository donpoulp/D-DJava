package GameRule;

import java.util.Arrays;

public class Board {
    int [] board;

    /// constructor ///
    public Board(int size) {
        this.board = new int[size];
    }

    /// getters ///
    public int[] getBoard() {return board;}

    /// setters ///
    public void setBoard(int[] board) {this.board = board;}

    /// toString ///
    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
