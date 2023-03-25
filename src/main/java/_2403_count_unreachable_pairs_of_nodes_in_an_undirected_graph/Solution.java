/**
 * 2403. Count Unreachable Pairs of Nodes in an Undirected Graph
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 */
package _2403_count_unreachable_pairs_of_nodes_in_an_undirected_graph;


import java.util.*;

class Solution {

    // `clusters[i]` - the cluster leader element of `i` or the other element
    // which once was a cluster leader (out of date value: in this case the current cluster leader
    // can be determined by recursion).
    int[] cluster;

    // `clusterSize[i]` - the number of elements in the cluster that is lead by `i`
    int[] clusterSize;

    int clusterOf(int node) {
        if (cluster[node] == node) { // `node` is cluster leader
            return node;
        }
        if (cluster[node] == cluster[cluster[node]]) {
            // it means that `clusters[node]` is a cluster leader, no need to update anything
            // since `cluster[node]` is up-to-date.
            return cluster[node];
        }
        // it means that this node's former cluster leader was absorbed by another cluster:
        // let us recurse further and update the leader afterwards
        return cluster[node] = this.clusterOf(cluster[node]);
    }

    public long countPairs(int n, int[][] edges) {
        cluster = new int[n];
        clusterSize = new int[n];
        for (int i = 0; i < n; i++) {
            cluster[i] = i; // initially, all elements belong to their own clusters...
            clusterSize[i] = 1; //... thus the size of each cluster is just 1
        }

        for (int[] link : edges) {
            int clusterA = this.clusterOf(link[0]);
            int clusterB = this.clusterOf(link[1]);
            if (clusterA == clusterB) continue;

            // the larger cluster gets all the smaller one's elements
            if (clusterSize[clusterA] >= clusterSize[clusterB]) {
                cluster[clusterB] = clusterA;
                clusterSize[clusterA] += clusterSize[clusterB];
                clusterSize[clusterB] = 0;
            } else {
                cluster[clusterA] = clusterB;
                clusterSize[clusterB] += clusterSize[clusterA];
                clusterSize[clusterA] = 0;
            }
        }
        // The answer is the co-pair products of the sizes of all clusters,
        // or in case of 3 clusters with sizes `a`, `b` and `c`:
        // answer = (ab + ac + bc)
        // Unfortunately, in worst case (when there are no edges and each cluster has a size 1)
        // the bruteforce algorithm is O(clusters^2).
        // Luckily, the following simple math trick improves the algorithm to just O(clusters):
        // Since:
        // (a+b+c)^2 = a^2 + b^2 +c^2 + 2 * (ab + ac + bc),
        // thus:
        // (ab + ac + bc) = ( (a+b+c)^2 - (a^2 + b^2 +c^2) ) / 2
        long plainSum = Arrays.stream(clusterSize).asLongStream().sum();
        long sumOfSquares = Arrays.stream(clusterSize).asLongStream().map(e -> e * e).sum();
        return (plainSum * plainSum - sumOfSquares) / 2;
    }
}