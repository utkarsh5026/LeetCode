package hash_tables.medium;

import java.util.*;

//https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/
// 3159. Find Occurrences of an Element in an Array
class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        Map<Integer, Integer> cntIdx = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                cnt++;
                cntIdx.put(cnt, i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            if (query <= cnt) {
                result[i] = cntIdx.get(query);
            }
        }

        return result;
    }
}