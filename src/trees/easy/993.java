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

// https://leetcode.com/problems/cousins-in-binary-tree/description/
// 993. Cousins in Binary Tree
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        return (findHeight(root, y) == findHeight(root, x)) && findParent(root, x) != findParent(root, y);
    }

    TreeNode findParent(TreeNode root, int target) {
        if (root == null)
            return null;

        if (root.left != null && root.left.val == target)
            return root;
        if (root.right != null && root.right.val == target)
            return root;

        TreeNode left = findParent(root.left, target);
        TreeNode right = findParent(root.right, target);

        if (left != null)
            return left;
        if (right != null)
            return right;

        return null;
    }

    int findHeight(TreeNode root, int target) {
        if (root == null)
            return 0;

        if (root.val == target)
            return 1;

        int left = findHeight(root.left, target);
        int right = findHeight(root.right, target);

        if (left > 0)
            return left + 1;
        if (right > 0)
            return right + 1;

        return 0;
    }
}