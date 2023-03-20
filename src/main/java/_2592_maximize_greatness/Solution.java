/**
 * 2592. Maximize Greatness of an Array
 * https://leetcode.com/contest/biweekly-contest-100/problems/maximize-greatness-of-an-array/
 */
package _2592_maximize_greatness;

import java.util.*;

public class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int num : nums) {
            queue.add(num);
            if (num > queue.peek()) {
                queue.poll();
                count++;
            }
        }
        return count;
    }
}

