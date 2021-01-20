
/**
 * A class which represents a move in the Sudoku game
 *
 * @author Vincent Dong and Miguel Oyler
 * @version 3/28/18
 */
public class SudokuMove
{
    
    private int digit; // number being placed
    private int row;
    private int col;
    
    /**
     * Constructs a SudokuMove, represents a single move in SudokuPuzzle
     */
    public SudokuMove(int digit, int row, int col)
    {
        this.digit = digit;
        this.row = row;
        this.col = col;
    }
    
    /**
     * Gets the row
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * Gets the col
     */
    public int getCol(){
        return this.col;
    }
    
    /**
     * Gets the digit
     */
    public int getDigit(){
        return this.digit;
    }
    
    /**
     * String representation of a SudokuMove
     */
    public String toString(){
        String myString = "";
        myString += "(Digit: " + digit + ", Row: " + row + ", Col: " + col + ")";
        return myString;
    }


}
