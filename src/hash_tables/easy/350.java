package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// 350. Intersection of Two Arrays II
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = buildFrequencyMap(nums1);
        List<Integer> list = findIntersect(map, nums2);
        return listToArray(list);
    }

    Map<Integer, Integer> buildFrequencyMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0);
            map.put(num, freq + 1);
        }
        return map;
    }

    List<Integer> findIntersect(Map<Integer, Integer> map, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (map.get(num) != null && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return list;
    }

    int[] listToArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}