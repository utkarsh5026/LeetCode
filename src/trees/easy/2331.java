package trees.easy;

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

// https://leetcode.com/problems/evaluate-boolean-binary-tree/description/
// 2331. Evaluate Boolean Binary Tree
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null)
            return false;

        boolean isLeaf = root.left == null && root.right == null;

        if (isLeaf)
            return root.val == 1;

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2)
            return left || right;
        else
            return left && right;
    }
}