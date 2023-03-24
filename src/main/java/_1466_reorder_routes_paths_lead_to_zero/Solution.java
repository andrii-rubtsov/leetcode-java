/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */
package _1466_reorder_routes_paths_lead_to_zero;


import java.util.*;

class TreeNode {
    int val;
    List<TreeNode> outgoing;
    List<TreeNode> incoming;

    public TreeNode(int val) {
        this.val = val;
        this.outgoing = new ArrayList<>();
        this.incoming = new ArrayList<>();
    }
}

public class Solution {

    TreeNode[] nodes;
    int reorders;

    public int minReorder(int n, int[][] connections) {
        this.reorders = 0;
        nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i);
        }

        for (int[] link : connections) {
            TreeNode from = nodes[link[0]];
            TreeNode to = nodes[link[1]];
            from.outgoing.add(to);
            to.incoming.add(from);
        }
        this.countReorders(nodes[0], null);
        return this.reorders;
    }

    void countReorders(TreeNode cur, TreeNode from) {
        for (TreeNode in : cur.incoming) {
            if (in == from) {
                continue;
            }
            this.countReorders(in, cur);
        }
        for (TreeNode out : cur.outgoing) {
            if (out == from) {
                continue;
            }
            this.reorders++;
            this.countReorders(out, cur);
        }
    }
}
