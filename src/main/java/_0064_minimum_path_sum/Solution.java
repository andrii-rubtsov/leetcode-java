/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 */
package _0064_minimum_path_sum;


class Solution {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] minPath = new int[n][m];
        minPath[n - 1][m - 1] = grid[n - 1][m - 1];
        for (int x = n - 2; x >= 0; x--) {
            minPath[x][m - 1] = grid[x][m - 1] + minPath[x + 1][m - 1];
        }
        for (int y = m - 2; y >= 0; y--) {
            minPath[n - 1][y] = grid[n - 1][y] + minPath[n - 1][y + 1];
        }
        for (int x = n - 2; x >= 0; x--) {
            for (int y = m - 2; y >= 0; y--) {
                minPath[x][y] = grid[x][y] + Math.min(
                        minPath[x + 1][y], minPath[x][y + 1]
                );
            }
        }
        return minPath[0][0];
    }

}