package trees.medium;

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

// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/
// 1123. Lowest Common Ancestor of Deepest Leaves
class Solution {

    private class Result {
        TreeNode node;
        int depth;

        Result(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else if (right.depth > left.depth) {
            return new Result(right.node, right.depth + 1);
        } else {
            return new Result(root, left.depth + 1);
        }
    }
}
