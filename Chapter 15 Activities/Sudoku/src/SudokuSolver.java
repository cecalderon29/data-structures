import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver {
    private final int M = 3;
    private final int N = M * M;
    private int[][] grid;
    private ArrayList<Set<Integer>> rows;
    private ArrayList<Set<Integer>> cols;
    private ArrayList<Set<Integer>> squares;
    private Set<Integer> nums;

    public SudokuSolver(String fileName) {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName))) {

            this.grid = new int[N][N];

            for (int row = 0; row < N; row++) {
                String line = in.next();

                for (int col = 0; col < N; col++) {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x")) {
                        number = 0;
                    } else {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + fileName);
        }


        // create the list of sets for each row (this.rows)
        for (int[] row : this.grid)
        {
            Set<Integer> tempSet = new HashSet<>();
            for(int val : row)
            {
                tempSet.add(val);
            }
            rows.add(tempSet);
        }

        // create the list of sets for each col (this.cols)
        for (int x = 0; x < this.grid.length; x++)
        {
            Set<Integer> tempSet = new HashSet<>();
            for (int y = 0; y < this.grid[x].length; y++)
            {
                tempSet.add(this.grid[y][x]);
            }
            this.cols.add(tempSet);
        }

        // create the list of sets for each square (this.squares)
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */

        for (int row = 0; row < this.M; row++){
            for (int col = 0; col < this.M; col++){
                Set<Integer> tempSet = new HashSet<>();
                for(int inRow = 0; inRow < this.M; inRow++){
                    for(int inCol = 0; inCol < this.M; inCol++){
                        tempSet.add(this.grid[row*M+inRow][col*M+inCol]);
                    }
                }
                this.squares.add(tempSet);
            }
        }
        
        //add set to list
        //max+=3

        // create a hash set for [1..9] (this.nums)
        for (int i = 1; i <= 9; i++)
        {
            nums.add(i);
        }

        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            System.out.println("row " + row + ": " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            System.out.println("col " + col + ": " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            System.out.println("square " + square + ": " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }

    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
        if (finished) {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<Integer>();
        possibleNums.addAll(this.nums);
        int index = -1;

        if (nextRow < 3)
        {
            if (nextCol < 3)
            {index = 0;}
            if (nextCol < 6)
            { index = 1;}
            if (nextCol < 9)
            {index = 2;  }
        }
        else if (nextRow < 6)
        {
            if (nextCol < 3)
            {index = 3; }
            if (nextCol < 6)
            { index = 4;}
            if (nextCol < 9)
            { index = 5; }
        }
        else if (nextRow < 9)
        {
            if (nextCol < 3)
            {index = 6;}
            if (nextCol < 6)
            {index = 7;}
            if (nextCol < 9)
            {index = 8;}
        }

        possibleNums.removeAll(rows.get(nextRow));
        possibleNums.removeAll(cols.get(nextCol));
        possibleNums.removeAll(squares.get(index));



        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            grid[nextRow][nextCol] = possibleNum;
            rows.get(nextRow).add(possibleNum);
            cols.get(nextCol).add(possibleNum);
            squares.get(index).add(possibleNum);

            
            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                grid[nextRow][nextCol] = 0;
                rows.get(nextRow).remove(possibleNum);
                cols.get(nextCol).remove(possibleNum);
                squares.get(index).remove(possibleNum);
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }

            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}