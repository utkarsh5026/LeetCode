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

// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
// 1339. Maximum Product of Splitted Binary Tree
class Solution {
    long maxProd = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        long totalSum = getTreeTotalSum(root);
        findMaxProd(root, totalSum);
        return (int) (maxProd % MOD);
    }

    long getTreeTotalSum(TreeNode root) {
        if (root == null)
            return 0;
        long left = getTreeTotalSum(root.left);
        long right = getTreeTotalSum(root.right);
        return left + right + root.val;
    }

    long findMaxProd(TreeNode root, long totalSum) {
        if (root == null)
            return 0;

        long left = findMaxProd(root.left, totalSum);
        long right = findMaxProd(root.right, totalSum);
        long currSum = left + right + root.val;
        // Calculate the product of the current subtree and the remaining part of the
        // tree
        long remaining = totalSum - currSum;
        long prod = remaining * currSum;
        maxProd = Math.max(maxProd, prod);
        return currSum;
    }
}
