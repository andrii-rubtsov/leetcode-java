/**
 * 2439. Longest Cycle in a Graph
 * https://leetcode.com/problems/longest-cycle-in-a-graph/
 */
package _2439_longest_cycle_in_a_graph;


class Solution {

    int[] seenAt;

    public int longestCycle(int[] edges) {
        seenAt = new int[edges.length];
        int longestCycle = -1;
        int time = 1;
        for (int i = 0; i < edges.length; i++) {
            if (seenAt[i] > 0) continue;
            int node = i;
            int startCycleTime = time;
            while (node != -1 && seenAt[node] == 0) {
                seenAt[node] = time++;
                node = edges[node];
            }
            if (node != -1 && seenAt[node] >= startCycleTime) {
                longestCycle = Math.max(longestCycle, time - seenAt[node]);
            }
            time++;
        }
        return longestCycle;
    }
}