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

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
// 1008. Construct Binary Search Tree from Preorder Traversal
class Solution {
    private int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildBST(int[] preorder, int min, int max) {
        if (idx >= preorder.length)
            return null;

        int val = preorder[idx];
        if (val < min || val > max)
            return null;

        TreeNode root = new TreeNode(val);
        idx++;
        root.left = buildBST(preorder, min, val);
        root.right = buildBST(preorder, val, max);

        return root;
    }
}
