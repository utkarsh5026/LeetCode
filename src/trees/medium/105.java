package trees.medium;

import java.util.HashMap;
import java.util.Map;

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

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// 105. Construct Binary Tree from Preorder and Inorder Traversal
class Solution {

    int preOrdIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdx.put(inorder[i], i);
        }

        return createTree(0, preorder.length - 1, inorderIdx, preorder);
    }

    TreeNode createTree(int left, int right, Map<Integer, Integer> inorderMap, int[] preorder) {
        if (left > right)
            return null;

        int node = preorder[preOrdIdx++];
        TreeNode root = new TreeNode(node);
        int mid = inorderMap.get(node);

        root.left = createTree(left, mid - 1, inorderMap, preorder);
        root.right = createTree(mid + 1, right, inorderMap, preorder);

        return root;
    }
}