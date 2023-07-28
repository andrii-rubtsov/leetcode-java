/**
 * 486. Predict the Winner
 * https://leetcode.com/problems/predict-the-winner/
 */
package _0486_predict_the_winner;


import java.util.Arrays;

class Solution {

    int[] nums;
    int[][] cache;

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        this.cache = new int[n][n];
        for (int[] c : cache) {
            Arrays.fill(c, Integer.MIN_VALUE);
        }
        return maxPlayerOneWin(0, n - 1, true) >= 0;
    }

    private int maxPlayerOneWin(int start, int end, boolean playerOneMove) {
        if (start > end) {
            return 0;
        }
        int cached = cache[start][end];
        if (cached == Integer.MIN_VALUE) {
            int sign = playerOneMove ? 1 : -1;
            if (start == end) {
                cached = sign * nums[start];
            } else {
                int maxWinTakeStart = sign * nums[start] + maxPlayerOneWin(start + 1, end, !playerOneMove);
                int maxWinTakeEnd = sign * nums[end] + maxPlayerOneWin(start, end - 1, !playerOneMove);
                if (playerOneMove) {
                    cached = Math.max(maxWinTakeStart, maxWinTakeEnd);
                } else {
                    cached = Math.min(maxWinTakeStart, maxWinTakeEnd);
                }
            }
            cache[start][end] = cached;
        }
        return cached;
    }

}