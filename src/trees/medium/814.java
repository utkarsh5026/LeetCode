package trees.medium;

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

// https://leetcode.com/problems/binary-tree-pruning/description/
// 814. Binary Tree Pruning
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        int ones = countOnes(root);
        return ones > 0 ? root : null;
    }

    int countOnes(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = countOnes(root.left);
        int right = countOnes(root.right);

        if (left == 0)
            root.left = null;
        if (right == 0)
            root.right = null;

        return root.val + left + right;
    }
}