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

// https://leetcode.com/problems/diameter-of-binary-tree/description/
// 543. Diameter of Binary Tree
class Solution {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        search(root);
        return diameter;
    }

    private int search(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return 0;

        int left = search(root.left);
        int right = search(root.right);

        int currDiameter = left + right + 1;
        diameter = Math.max(diameter, currDiameter);

        return Math.max(left, right) + 1;
    }
}