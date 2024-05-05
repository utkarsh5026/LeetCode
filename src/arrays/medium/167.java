package arrays.medium;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// 167. Two Sum II - Input Array Is Sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int fromStart = numbers[start];
            int fromEnd = numbers[end];

            int currSum = fromEnd + fromStart;
            if (currSum == target)
                return new int[] { start + 1, end + 1 };

            if (currSum > target)
                end--;
            else
                start++;
        }

        return new int[] { -1, -1 };
    }
}
