import java.util.*;
import java.util.Map.Entry;

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

// https://leetcode.com/problems/most-frequent-subtree-sum/description/
// 508. Most Frequent Subtree Sum
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> subTreeSums = new HashMap<>();
        solve(root, subTreeSums);

        if (subTreeSums.isEmpty())
            return new int[] {};

        int maxValue = Collections.max(subTreeSums.values());

        List<Integer> mostFrequent = new ArrayList<>();

        for (Entry<Integer, Integer> sum : subTreeSums.entrySet()) {
            if (sum.getValue() == maxValue)
                mostFrequent.add(sum.getKey());
        }

        int[] result = new int[mostFrequent.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = mostFrequent.get(i);
        }
        return result;
    }

    int solve(TreeNode root, Map<Integer, Integer> subTreeSums) {
        if (root == null)
            return 0;

        int left = solve(root.left, subTreeSums);
        int right = solve(root.right, subTreeSums);

        int currentSum = left + right + root.val;
        subTreeSums.computeIfAbsent(currentSum, k -> 0);
        subTreeSums.put(currentSum, subTreeSums.get(currentSum) + 1);

        return currentSum;
    }
}