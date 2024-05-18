package trees.medium;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// https://leetcode.com/problems/balance-a-binary-search-tree/description/
// 1382. Balance a Binary Search Tree
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return balance(0, inorder.size() - 1, inorder);
    }

    void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if (root == null)
            return;

        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }

    TreeNode balance(int start, int end, List<Integer> inorder) {
        if (start > end)
            return null;

        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(inorder.get(middle));

        root.left = balance(start, middle - 1, inorder);
        root.right = balance(middle + 1, end, inorder);

        return root;
    }

}
