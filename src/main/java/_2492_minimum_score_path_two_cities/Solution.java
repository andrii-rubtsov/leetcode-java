/**
 * 2492. Minimum Score of a Path Between Two Cities
 * https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
 */
package _2492_minimum_score_path_two_cities;

import java.util.HashMap;

public class Solution {
    public int minScore(int n, int[][] roads) {
        HashMap<Integer, HashMap<Integer, Integer>> distances = new HashMap<>();
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int dist = road[2];
            HashMap<Integer, Integer> aNodes = distances.computeIfAbsent(a, k -> new HashMap<>());
            aNodes.put(b, dist);
            HashMap<Integer, Integer> bNodes = distances.computeIfAbsent(b, k -> new HashMap<>());
            bNodes.put(a, dist);
        }

        boolean[] visited = new boolean[n + 1];
        return minWidth(1, visited, distances);
    }

    Integer minWidth(int node, boolean[] visited, HashMap<Integer, HashMap<Integer, Integer>> distances) {
        if (!visited[node]) {
            visited[node] = true;
        } else {
            return Integer.MAX_VALUE;
        }
        HashMap<Integer, Integer> dist = distances.get(node);
        int minValue = Integer.MAX_VALUE;
        for (int target : dist.keySet()) {
            int targetDist = dist.get(target);
            minValue = Math.min(minValue, targetDist);
            Integer minWidth = minWidth(target, visited, distances);
            minValue = Math.min(minValue, minWidth);
        }
        return minValue;
    }

}



