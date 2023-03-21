/**
 * 2348. Number of Zero-Filled Subarrays
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 */

package _2348_number_zero_filled_subarrays;
import java.util.*;

public class Solution {

    public long zeroFilledSubarray(int[] nums) {
        long zerosLength = 0;
        long numZeroSubarrays = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zerosLength++;
            } else if (zerosLength > 0) {
                numZeroSubarrays += zerosLength * (zerosLength + 1) / 2;
                zerosLength = 0;
            }
        }
        numZeroSubarrays += zerosLength * (zerosLength + 1) / 2; // possibly a leftover
        return numZeroSubarrays;
    }
}