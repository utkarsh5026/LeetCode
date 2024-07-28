package queues.medium;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

// https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
// 958. Check Completeness of a Binary Tree
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean endFlag = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                if (endFlag)
                    return false;

                queue.offer(node.left);
            } else
                endFlag = true;

            if (node.right != null) {
                if (endFlag)
                    return false;

                queue.offer(node.right);
            } else
                endFlag = true;

        }

        return true;
    }
}