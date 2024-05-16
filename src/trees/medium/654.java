package trees.medium;

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

// https://leetcode.com/problems/maximum-binary-tree/description/
// 654. Maximum Binary Tree
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums.length == 0)
            return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;

        int maxIdx = findMaxIdx(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIdx]);

        root.left = buildTree(nums, start, maxIdx - 1);
        root.right = buildTree(nums, maxIdx + 1, end);

        return root;
    }

    int findMaxIdx(int[] nums, int start, int end) {
        int maxIdx = start;
        for (int i = start; i <= end; i++) {
            int curr = nums[i];
            if (curr > nums[maxIdx])
                maxIdx = i;
        }
        return maxIdx;
    }
}