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

// https://
// leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// 235. Lowest Common Ancestor of a Binary Search Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        int rootVal = root.val;

        if (rootVal == p.val || rootVal == q.val)
            return root;

        if ((rootVal > p.val && rootVal < q.val) || (rootVal < p.val && rootVal > q.val))
            return root;

        if (rootVal > p.val && rootVal > q.val)
            return lowestCommonAncestor(root.left, p, q);

        if (rootVal < p.val && rootVal < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return null;
    }
}
