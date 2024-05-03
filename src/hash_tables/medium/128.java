package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
// 128. Longest Consecutive Sequence
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = createNumsSet(nums);
        int longest = 0;
        for (int num : nums) {
            int sequenceLength = getConsecutiveSequenceLength(num, numsSet);
            longest = Math.max(longest, sequenceLength);
        }
        return longest;
    }

    private Set<Integer> createNumsSet(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        return numSet;
    }

    private int getConsecutiveSequenceLength(int curr, Set<Integer> numsSet) {
        int smaller = curr - 1;
        if (numsSet.contains(smaller))
            return 0;

        int length = 0;
        while (!numsSet.isEmpty()) {
            if (!numsSet.contains(curr))
                break;
            numsSet.remove(curr);
            curr++;
            length++;
        }

        return length;
    }
}