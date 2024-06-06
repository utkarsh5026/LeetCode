package hash_tables.easy;

// https:// leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
// 2006. Count Number of Pairs With Absolute Difference K
class Solution {
    public int countKDifference(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k)
                    cnt++;
            }
        }
        return cnt;
    }
}
