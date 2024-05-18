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

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
// 1038. Binary Search Tree to Greater Sum Tree
class Solution {

    int greaterSum = 0;

    public TreeNode bstToGst(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    void reverseInorder(TreeNode root) {
        if (root == null)
            return;

        reverseInorder(root.right);
        greaterSum += root.val;
        root.val = greaterSum;
        reverseInorder(root.left);
    }

}