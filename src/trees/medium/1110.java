package trees.medium;

import java.util.*;

// https://leetcode.com/problems/delete-nodes-and-return-forest/description/
// 1110. Delete Nodes And Return Forest
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : toDelete) {
            toDeleteSet.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();
        helper(root, toDeleteSet, forest, true);
        return forest;
    }

    private TreeNode helper(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest, boolean isRoot) {
        if (node == null) {
            return null;
        }

        boolean toDelete = toDeleteSet.contains(node.val);
        if (isRoot && !toDelete) {
            forest.add(node);
        }

        node.left = helper(node.left, toDeleteSet, forest, toDelete);
        node.right = helper(node.right, toDeleteSet, forest, toDelete);

        return toDelete ? null : node;
    }
}