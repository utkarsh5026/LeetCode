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

// https://leetcode.com/problems/print-binary-tree/description/
// 655. Print Binary Tree
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        int height = height(root);
        int width = (int) Math.pow(2, height) - 1;
        List<List<String>> result = new ArrayList<>();
        initializeResult(result, height, width);
        fillResult(root, result, 0, width - 1, 0);
        return result;
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

    void initializeResult(List<List<String>> result, int height, int width) {
        for (int i = 0; i < height; i++) {
            List<String> level = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                level.add("");
            }
            result.add(level);
        }
    }

    void fillResult(TreeNode root, List<List<String>> result, int left, int right, int height) {
        if (root == null)
            return;

        int position = (left + right) / 2;
        result.get(height).set(position, String.valueOf(root.val));

        fillResult(root.left, result, left, position - 1, height + 1);
        fillResult(root.right, result, position + 1, right, height + 1);
    }
}
