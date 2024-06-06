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

// https://leetcode.com/problems/find-duplicate-subtrees/description/
// 652. Find Duplicate Subtrees
class Solution {
    Map<String, Integer> count;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        result = new ArrayList<>();
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null)
            return "#";

        String serial = node.val + "," + serialize(node.left) + "," + serialize(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);

        if (count.get(serial) == 2) {
            result.add(node);
        }

        return serial;
    }
}
