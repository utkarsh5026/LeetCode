package trees.medium;

// https://leetcode.com/problems/delete-leaves-with-a-given-value/description/
// 1325. Delete Leaves With a Given Value
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        if (isLeaf(root) && root.val == target)
            return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (isLeaf(root) && root.val == target)
            return null;
        return root;
    }

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
