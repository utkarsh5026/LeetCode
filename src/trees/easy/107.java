package trees.easy;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
// 107. Binary Tree Level Order Traversal II
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        dfs(root, levels, 0);
        Collections.reverse(levels);
        return levels;
    }

    void dfs(TreeNode root, List<List<Integer>> levels, int level) {
        if (root == null)
            return;

        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        dfs(root.left, levels, level + 1);
        dfs(root.right, levels, level + 1);
    }
}