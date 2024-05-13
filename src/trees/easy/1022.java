package trees.easy;

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

// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/
// 1022. Sum of Root To Leaf Binary Numbers
class Solution {
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        countTotalSum(root, new ArrayList<>());
        return sum;
    }

    void countTotalSum(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;

        nodes.add(root.val);
        if (root.left == null && root.right == null) {
            for (int i = 0; i < nodes.size(); i++) {
                int power = nodes.size() - 1 - i;
                if (nodes.get(i) == 1)
                    sum += Math.pow(2, power);
            }
        }

        countTotalSum(root.left, nodes);
        countTotalSum(root.right, nodes);
        nodes.remove(nodes.size() - 1);
    }

}