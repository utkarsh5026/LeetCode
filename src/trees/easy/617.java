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

// https://leetcode.com/problems/merge-two-binary-trees/description/
// 617. Merge Two Binary Trees
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;

        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        TreeNode left = merge(t1.left, t2.left);
        TreeNode right = merge(t1.right, t2.right);
        t1.val = t1.val + t2.val;
        t1.left = left;
        t1.right = right;

        return t1;
    }
}