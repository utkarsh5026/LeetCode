package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
// 
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> aSet = this.createSetFromArray(nums1);
        Set<Integer> bSet = this.createSetFromArray(nums2);
        List<Integer> notInB = findSetDiffElements(aSet, bSet);
        List<Integer> notInA = findSetDiffElements(bSet, aSet);

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(notInB);
        listOfLists.add(notInA);
        return listOfLists;

    }

    private Set<Integer> createSetFromArray(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        return numsSet;
    }

    private List<Integer> findSetDiffElements(Set<Integer> aSet, Set<Integer> bSet) {
        List<Integer> diff = new ArrayList<>();
        for (int num : aSet) {
            if (bSet.contains(num))
                continue;
            diff.add(num);
        }
        return diff;
    }
}