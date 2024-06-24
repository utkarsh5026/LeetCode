package trees.medium;

import java.util.*;

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

// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
// 1315. Sum of Nodes with Even-Valued Grandparents
class Solution {

    private int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        int treeHeight = height(root);
        int[] path = new int[treeHeight];
        Arrays.fill(path, -1);
        dfs(root, path, 0);

        return sum;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 1;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void dfs(TreeNode root, int[] path, int height) {
        if (root == null)
            return;

        path[height] = root.val;

        if (height >= 2) {
            int grandParent = path[height - 2];
            if (grandParent % 2 == 0)
                sum += root.val;
        }

        dfs(root.left, path, height + 1);
        dfs(root.right, path, height + 1);
    }
}