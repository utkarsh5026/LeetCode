package greedy.easy;

// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/
// 1013. Partition Array Into Three Parts With Equal Sum
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = totalSum(arr);

        if (sum % 3 != 0)
            return false;

        int partSum = sum / 3;

        int parts = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == partSum) {
                parts++;
                currSum = 0;
            }

            if (parts == 3)
                return true;
        }

        return parts == 3;
    }

    int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
