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

// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/
// 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null)
            return null;
        if (isSubTree(cloned, target))
            return cloned;

        TreeNode left = getTargetCopy(original, cloned.left, target);

        TreeNode right = getTargetCopy(original, cloned.right, target);

        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }

    boolean isSubTree(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;

        if (a.val == b.val)
            return isSubTree(a.left, b.left) && isSubTree(a.right, b.right);

        return false;
    }
}