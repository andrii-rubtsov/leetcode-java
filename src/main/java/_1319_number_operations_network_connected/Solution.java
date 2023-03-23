/**
 * 1319. Number of Operations to Make Network Connected
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
package _1319_number_operations_network_connected;


public class Solution {

    int elemsFound;
    int clusterCount;
    int[] clusters;

    int clusterOf(int node) {
        if (clusters[node] < 0) {
            // if node is primary, return node itself to be used as a link
            return node;
        }
        // recurse further and update the shortcut afterwards
        return clusters[node] = this.clusterOf(clusters[node]);
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        clusters = new int[n+1];
        elemsFound = 0;

        for (int[] link : connections) {
            int a = Math.min(link[0], link[1]) + 1;
            int b = Math.max(link[0], link[1]) + 1;
            if (clusters[a] == 0 && clusters[b] == 0) {
                clusters[a] = -(++elemsFound);
                clusters[b] = a;
                elemsFound++;
                clusterCount++;
            } else if (clusters[a] == 0) {
                clusters[a] = this.clusterOf(b);
                elemsFound += 1;
            } else if (clusters[b] == 0) {
                clusters[b] = this.clusterOf(a);
                elemsFound += 1;
            } else {
                if (this.clusterOf(a) != this.clusterOf(b)) {
                    clusters[this.clusterOf(b)] = this.clusterOf(a);
                    clusterCount--;
                }
            }
        }

        return (n - elemsFound)  + (clusterCount - 1);
    }

}
