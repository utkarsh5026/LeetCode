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

// https://leetcode.com/problems/deepest-leaves-sum/description/
// 1302. Deepest Leaves Sum
class Solution {
    int deepestSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;

        int maxDepth = findMaxDepth(root);
        calculateDeepestSum(root, 0, maxDepth);
        return deepestSum;
    }

    int findMaxDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int left = findMaxDepth(root.left);
        int right = findMaxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    void calculateDeepestSum(TreeNode node, int level, int maxDepth) {
        if (node == null)
            return;

        if (level == maxDepth)
            deepestSum += node.val;
        calculateDeepestSum(node.left, level, maxDepth);
        calculateDeepestSum(node.right, level, maxDepth);
    }

}
