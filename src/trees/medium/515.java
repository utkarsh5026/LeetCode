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

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
// 515. Find Largest Value in Each Tree Row
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        findLargest(root, 0, values);
        return values;
    }

    void findLargest(TreeNode root, int level, List<Integer> values) {
        if (root == null)
            return;

        if (values.size() == level)
            values.add(root.val);

        int currVal = values.get(level);
        values.set(level, Math.max(currVal, root.val));

        findLargest(root.left, level + 1, values);
        findLargest(root.right, level + 1, values);
    }
}