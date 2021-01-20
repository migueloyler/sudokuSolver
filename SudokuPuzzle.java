

/**
 * A particular configuration of a Sudoku puzzle (either a starting 
 *      configuration, a solved puzzle, or an intermediate configuration).
 *
 * @author Vincent Dong and Miguel Oyler
 * @version 3/28/18
 */

import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class SudokuPuzzle
{
    // The Sudoku Board
    private int[][] board;
    
    private Scanner scan;
    
    private static final int NUMROWS = 9; // Board has 9 Rows and Cols
    private static final int NUMCOLS = 9;
    
    private static final int BOX = 3; // 3x3 box
    
    private static final int COORDSLENGTH = 2; // [row, col] 

    /**
     * Reads in a text file and constructs a SudokuPuzzle
     * 
     * @param   a text file - str
     */
    public SudokuPuzzle(String filename)
    {
        board = new int[NUMROWS][NUMCOLS];
        try {
            scan = new Scanner(new File(filename));
            
            for (int row = 0; row < NUMROWS; row++) {
                for (int col = 0; col < NUMCOLS; col++) {
                    
                    int num = scan.nextInt();
                    board[row][col] = num;
                
                }
            }
            scan.close();
            
        } catch (Exception e) {
            System.out.println("");
        }
        
    }
    
    /**
     * String representation of a SudokuPuzzle   
     */
    
    public String toString(){
        String puzzleView = "";
        for(int i = 0; i < NUMROWS ; i++){
            for (int j = 0; j < NUMCOLS; j++){
                puzzleView += this.board[i][j];
                puzzleView += " ";
                if(j == (NUMCOLS - 1)){
                    puzzleView += "\n";
                }
            }
        }
        return puzzleView;
    }
    
    /**
     * Checks whether obj is equivalent to this object (whether 2 Sudoku
     *      Puzzles match)
     *
     * @param     obj  an Object   (a Sudoku Puzzle)
     * @return    true if obj matches this object (the Sudoku Puzzles match)
     */
    
    public boolean equals(Object obj)
    {
        if (obj instanceof SudokuPuzzle) {
            // obj is of type T
            SudokuPuzzle solution = (SudokuPuzzle) obj; 
            for (int row = 0; row < NUMROWS; row++) {
                for (int col = 0; col < NUMCOLS; col++) {
                    if (solution.board[row][col] != this.board[row][col]){
                        return false;
                    }
                }
            }
            return true;
        } 
        
        else {
            // obj is not of type T
            return false;
        }
    }
    
    /**
     * Checks to see if a digit placement is legal given row and col
     * 
     * @param   digit - number being placed - int
     * @param   row - int
     * @param   col - int
     * 
     * @return  true if digit placement is legal. 
     */
    public boolean isLegalMove(int digit, int row, int col) {
        int boxRow = row / BOX;
        int boxCol = col / BOX;
        if (digit < 1) {
            return false;
        }
        if (board[row][col] != 0) {
            return false;
        }
        
        for (int i = 0; i < NUMROWS; i++) {
            if (board[row][i] == digit) {
                return false;
            }
            if (board[i][col] == digit) {
                return false;
            }
        }
        
        for (int i = boxRow * BOX; i < (boxRow * BOX) + BOX; i++) {
            for (int j = boxCol * BOX; j < (boxCol * BOX) + BOX; j++) {
                if(board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * A void method in which interacts with the SudokuPuzzle
     * 
     * @param   digit - number being placed - int
     * @param   row - int
     * @param   col - int
     */
    public void interact(int digit, int row, int col) {
        if (digit == 0){
            board[row][col] = digit;
        }
        if (isLegalMove(digit, row, col)) {
            board[row][col] = digit;
        }
    }    
    
    /**
     * Searches for an empty spot (zero) in the Sudoku board
     * 
     * @return    coordinates of a zero represented as an array. 
     */
    public int[] zeroSpot() {
        int[] coords = new int[COORDSLENGTH];
        
        for (int row = 0; row < NUMROWS; row++) {
            for (int col = 0; col < NUMCOLS; col++) {
                if (this.board[row][col] == 0){
                    coords[0] = row;
                    coords[1] = col;
                    return coords;
                }
            }     
        }
        coords[0] = -1; // can't find a zero
        return coords;
    }
  
    /**
     * Checks to see if the SudokuPuzzle game is over. 
     * 
     * @return      true if the SudokuPuzzle is complete
     */
    public boolean gameOver(){
        for (int row = 0; row < NUMROWS; row++) {
                for (int col = 0; col < NUMCOLS; col++) {
                    if (board[row][col] == 0){
                        return false;
                    }
                }
            }
        return true;
    }
}
