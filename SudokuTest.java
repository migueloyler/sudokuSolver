
/**
 * Write a description of class SudokuTest here.
 *
 * @author Vincent Dong and Miguel Oyler
 * @version 3/28/18
 */

import java.util.Scanner;
public class SudokuTest
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter filename of puzzle: ");
        String filename = scan.nextLine();
        System.out.println("Enter filename of solution (optional) ");
        String solution = scan.nextLine();
        SudokuPuzzle test = new SudokuPuzzle(filename);
        SudokuPuzzle answer = new SudokuPuzzle(solution);
        System.out.println("Starting puzzle: ");
        System.out.println(test);
        SudokuSolver solved = new SudokuSolver(test);
        System.out.println("Solved Puzzle: ");
        if (solved.solve(test)){
            System.out.println(test);
            if (test.equals(answer)){
                System.out.println("Solution is correct!");
            } else if (solution.equals("")){
                
            } else {
                System.out.println("Solution is NOT correct");
            }
        }
    }
}

