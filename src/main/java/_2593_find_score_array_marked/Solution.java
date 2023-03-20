/**
 * 2593. Find Score of an Array After Marking All Elements
 * https://leetcode.com/contest/biweekly-contest-100/problems/find-score-of-an-array-after-marking-all-elements/
 */
package _2593_find_score_array_marked;

import java.util.*;

public class Solution {
    public long findScore(int[] nums) {
        TreeMap<Integer, LinkedList<Integer>> sorted = new TreeMap<>();
        boolean[] marked = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            LinkedList<Integer> indexes;
            if (!sorted.containsKey(elem)) {
                indexes = new LinkedList<>();
                sorted.put(elem, indexes);
            } else {
                indexes = sorted.get(elem);
            }
            indexes.add(i);
        }
        long score = 0;
        for (Integer elem : sorted.keySet()) {
            for (Integer idx : sorted.get(elem)) {
                if (marked[idx]) {
                    continue;
                } else {
                    score += elem;
                    if (idx > 0) {
                        marked[idx - 1] = true;
                    }
                    if (idx < nums.length - 1) {
                        marked[idx + 1] = true;
                    }
                }
            }
        }
        return score;
    }
}