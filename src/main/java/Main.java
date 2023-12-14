import org.example.Sudoku;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main( String[] args ) {
       ArrayList<ArrayList<Integer>> m = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row0 = new ArrayList<>(Arrays.asList(5, 3, 0, 0, 7, 0, 0, 0, 0));
        ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(6, 0, 0, 1, 9, 5, 0, 0, 0));
        ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(0, 9, 8, 0, 0, 0, 0, 6, 0));
        ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(8, 0, 0, 0, 6, 0, 0, 0, 3));
        ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(4, 0, 0, 8, 0, 3, 0, 0, 1));
        ArrayList<Integer> row5 = new ArrayList<>(Arrays.asList(7, 0, 0, 0, 2, 0, 0, 0, 6));
        ArrayList<Integer> row6 = new ArrayList<>(Arrays.asList(0, 6, 0, 0, 0, 0, 2, 8, 0));
        ArrayList<Integer> row7 = new ArrayList<>(Arrays.asList(0, 0, 0, 4, 1, 9, 0, 0, 5));
        ArrayList<Integer> row8 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 8, 0, 0, 7, 9));
        m.add(row0);
        m.add(row1);
        m.add(row2);
        m.add(row3);
        m.add(row4);
        m.add(row5);
        m.add(row6);
        m.add(row7);
        m.add(row8);


        Sudoku sudoku = new Sudoku(m);
        if (sudoku.solve()) {
            System.out.println("Solution found with " + sudoku.getMov() + " movementes:\n" + sudoku);
        } else {
            System.out.println("No solution exists");
        }


    }
}
