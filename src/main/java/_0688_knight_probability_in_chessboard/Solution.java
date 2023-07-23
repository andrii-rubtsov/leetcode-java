/**
 * 688. Knight Probability in Chessboard
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 */
package _0688_knight_probability_in_chessboard;

class Solution {

    private int n;
    private double[][][] cache;

    public double knightProbability(int n, int maxMoves, int initialRow, int initialCol) {
        this.n = n;
        this.cache = new double[maxMoves + 1][n][n];
        return getProbability(initialRow, initialCol, maxMoves);
    }

    private boolean onBoard(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < n;
    }

    private double getProbability(int row, int col, int moves) {
        double result = 0;
        if (!onBoard(row, col)) {
            return 0.0;
        }
        if (cache[moves][row][col] > 0) {
            return cache[moves][row][col];
        }
        if (moves == 0) {
            result = 1.0;
        } else {
            // up
            result += getProbability(row - 2, col + 1, moves - 1);
            result += getProbability(row - 2, col - 1, moves - 1);
            // down
            result += getProbability(row + 2, col + 1, moves - 1);
            result += getProbability(row + 2, col - 1, moves - 1);
            // left
            result += getProbability(row - 1, col - 2, moves - 1);
            result += getProbability(row + 1, col - 2, moves - 1);
            // right
            result += getProbability(row - 1, col + 2, moves - 1);
            result += getProbability(row + 1, col + 2, moves - 1);

            result /= 8.0;
        }

        cache[moves][row][col] = result;
        return result;
    }

}