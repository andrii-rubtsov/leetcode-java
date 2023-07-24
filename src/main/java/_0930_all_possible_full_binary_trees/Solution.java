/**
 * 930. All Possible Full Binary Trees
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 */
package _0930_all_possible_full_binary_trees;


import common.TreeNode;

import java.util.*;

class Solution {

    int currentNodeCount;
    int targetNodeCount;
    List<TreeNode> solutions;
    TreeNode root;

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return List.of();
        }

        this.targetNodeCount = n;
        this.currentNodeCount = 1;
        this.solutions = new ArrayList<>();
        this.root = new TreeNode(0);
        tryAddingToLeaves(List.of(root));

        return this.solutions;
    }

    void tryAddingToLeaves(List<TreeNode> leaves) {
        if (this.currentNodeCount == this.targetNodeCount) {
            this.solutions.add(cloneTree(this.root));
        }
        if (this.currentNodeCount + 2 > this.targetNodeCount) {
            return;
        }

        for (int i = 0; i < leaves.size(); i++) {
            TreeNode leaf = leaves.get(i);
            leaf.left = new TreeNode(0);
            leaf.right = new TreeNode(0);
            this.currentNodeCount += 2;

            List<TreeNode> newLeaves = new ArrayList<>();
            newLeaves.add(leaf.left);
            newLeaves.add(leaf.right);
            newLeaves.addAll(leaves.subList(i+1, leaves.size()));

            tryAddingToLeaves(newLeaves);

            leaf.left = null;
            leaf.right = null;
            this.currentNodeCount -= 2;
        }
    }

    static TreeNode cloneTree(TreeNode root) {
        TreeNode newRoot = new TreeNode(root.val);
        if (root.left != null) {
            newRoot.left = cloneTree(root.left);
        }
        if (root.right != null) {
            newRoot.right = cloneTree(root.right);
        }
        return newRoot;
    }

}