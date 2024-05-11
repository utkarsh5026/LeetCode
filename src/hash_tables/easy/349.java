package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/intersection-of-two-arrays/description/
// 349. Intersection of Two Arrays
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = arrayToSet(nums1);
        Set<Integer> intersect = findIntersection(set1, nums2);
        return setToArray(intersect);
    }

    private Set<Integer> arrayToSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    private Set<Integer> findIntersection(Set<Integer> set, int[] nums) {
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }
        return intersect;
    }

    private int[] setToArray(Set<Integer> set) {
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
}
