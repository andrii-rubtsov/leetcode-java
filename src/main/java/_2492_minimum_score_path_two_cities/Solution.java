/**
 * 2492. Minimum Score of a Path Between Two Cities
 * https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
 */
package _2492_minimum_score_path_two_cities;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    boolean[] visited;
    HashMap<Integer, HashMap<Integer, Integer>> distances;

    public int minScore(int n, int[][] roads) {
        distances = new HashMap<>();
        for (int[] road : roads) {
            distances.computeIfAbsent(road[0], k -> new HashMap<>()).put(road[1], road[2]);
            distances.computeIfAbsent(road[1], k -> new HashMap<>()).put(road[0], road[2]);
        }

        visited = new boolean[n];
        return minWidth(1);
    }

    Integer minWidth(int node) {
        int minValue = Integer.MAX_VALUE;
        if (!visited[node - 1]) {
            visited[node - 1] = true;
        } else {
            return minValue;
        }
        for (Map.Entry<Integer, Integer> e : distances.get(node).entrySet()) {
            minValue = Math.min(minValue, Math.min(e.getValue(), minWidth(e.getKey())));
        }
        return minValue;
    }

}



