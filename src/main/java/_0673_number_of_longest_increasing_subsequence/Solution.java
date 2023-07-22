/**
 * 673. Number of Longest Increasing Subsequence
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
package _0673_number_of_longest_increasing_subsequence;

import java.util.stream.IntStream;

class Solution {

    public int findNumberOfLIS(int[] nums) {
        int[] longestChainLength = new int[nums.length];
        int[] longestChainCount = new int[nums.length];
        int longestSoFar = 0;
        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            int longest = IntStream.range(0, i)
                    .filter(idx -> nums[idx] < currValue)
                    .map(idx -> longestChainLength[idx])
                    .max().orElse(0);
            longestChainLength[i] = longest + 1;
            longestChainCount[i] = Math.max(
                    IntStream.range(0, i)
                            .filter(idx -> nums[idx] < currValue && longestChainLength[idx] == longest)
                            .map(idx -> longestChainCount[idx])
                            .sum(),
                    1
            );
            longestSoFar = Math.max(longestSoFar, longestChainLength[i]);
        }
        int maxChainLen = longestSoFar;
        return IntStream.range(0, nums.length)
                .filter(idx -> longestChainLength[idx] == maxChainLen)
                .map(idx -> longestChainCount[idx])
                .sum();
    }
}