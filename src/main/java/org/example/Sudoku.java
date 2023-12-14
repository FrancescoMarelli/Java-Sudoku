package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {
    private static final int N = 9;
    private static final int kSubgrid = 3;

    private ArrayList<ArrayList<Integer>> m;
    int movimientos;

    public Sudoku(ArrayList<ArrayList<Integer>> m) {
        this.m = m;
    }

    private boolean findEmptyCell(int[] pos) {
        for (pos[0] = 0; pos[0] < N; ++pos[0])
            for (pos[1] = 0; pos[1] < N; ++pos[1])
                if (this.m.get(pos[0]).get(pos[1]) == 0)
                    return true;
        return false;
    }

    private boolean checkRow(int row, int num) {
        for (int col = 0; col < N; ++col) {
            if (this.m.get(row).get(col) == num) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, int num) {
        for (int row = 0; row < N; ++row)
            if (this.m.get(row).get(col) == num)
                return false;
        return true;
    }

    private boolean checkBox(int startRow, int startCol, int num) {
        for (int row = 0; row < kSubgrid; ++row)
            for (int col = 0; col < kSubgrid; ++col)
                if (this.m.get(startRow + row).get(startCol + col) == num)
                    return false;

        return true;
    }

    private boolean checkAll(int row, int col, int num) {
        return checkRow(row, num) && checkCol(col, num) && checkBox(row - row % kSubgrid, col - col % kSubgrid, num);
    }

    public boolean solve() {
        movimientos++;
        int[] pos = new int[2];
        if (!findEmptyCell(pos))
            return true;

        int row = pos[0];
        int col = pos[1];

        for (int num = 1; num <= N; ++num) {
            if (checkAll(row, col, num)) {
                m.get(row).set(col, num);
                if (solve())
                    return true;
                m.get(row).set(col, 0);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; ++row) {
           for (int col = 0; col < N; ++col) {
               sb.append(m.get(row).get(col)).append(" ");
           }
              sb.append("\n");
        }
        return sb.toString();
    }

    public int getMov() {
        return movimientos;
    }
}
