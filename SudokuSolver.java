

/**
 * A class that solves the SudokuPuzzle.
 *
 * @author Vincent Dong and Miguel Oyler
 * @version 3/28/18
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class SudokuSolver
{
   
    private SudokuPuzzle game;
    
    private static final int NUMROW = 9;

    /**
     * Constructs a SudokuSolver in which copies a SudokuPuzzle
     * 
     * @param       a SudokuPuzzle
     */
    public SudokuSolver(SudokuPuzzle puzzle)
    {
        this.game = puzzle;
    }

    /**
     * Solves the SudokuPuzzle
     *
     * @param  game - a SudokuPuzzle to be solved
     * @return    int 1 if SudokuPuzzle game is complete, -1 if not
     */
    public boolean solve(SudokuPuzzle game)
    {
        LinkedList<SudokuMove> myMoves = new LinkedList<SudokuMove>();
        
        if (game.gameOver()){ // base case
            return true;
        }
        
        for (int i = 1; i <= NUMROW; i++) {
            if (game.isLegalMove(i, game.zeroSpot()[0], game.zeroSpot()[1])){
                int zeroRow = game.zeroSpot()[0];
                int zeroCol = game.zeroSpot()[1];
                game.interact(i, zeroRow, zeroCol);
                myMoves.add(new SudokuMove(i, zeroRow, zeroCol));
                
                if (solve(game)){ //step towards base case
                    return true;
                }
                
                SudokuMove backtrack = myMoves.pop();
                game.interact(0, backtrack.getRow(), backtrack.getCol());
            }
        }
        return false; 
    }
}
