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

// https://leetcode.com/problems/cousins-in-binary-tree-ii/description/
// 2641. Cousins in Binary Tree II
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Map<Integer, Integer> levelSum = new HashMap<>();
        computeLevelSum(root, levelSum);

        TreeNode replace = replaceWithCousinsSum(root, 0, levelSum);
        replace.val = 0;
        return replace;
    }

    private void computeLevelSum(TreeNode root, Map<Integer, Integer> levelSum) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelSum.put(level++, sum);
        }
    }

    private TreeNode replaceWithCousinsSum(TreeNode root, int level, Map<Integer, Integer> levelSum) {
        if (root == null) {
            return null;
        }

        int sumOfLevel = levelSum.getOrDefault(level + 1, 0);
        int sumOfSiblings = 0;

        if (root.left != null)
            sumOfSiblings += root.left.val;

        if (root.right != null)
            sumOfSiblings += root.right.val;

        if (root.left != null) {
            root.left.val = sumOfLevel - sumOfSiblings;
            replaceWithCousinsSum(root.left, level + 1, levelSum);
        }

        if (root.right != null) {
            root.right.val = sumOfLevel - sumOfSiblings;
            replaceWithCousinsSum(root.right, level + 1, levelSum);
        }

        return root;
    }
}
