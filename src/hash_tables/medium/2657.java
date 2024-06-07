package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
// 2657. Find the Prefix Common Array of Two Arrays
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] prefix = new int[A.length];
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        for (int i = 0; i < prefix.length; i++) {
            Set<Integer> intersection = new HashSet<>(aSet);
            intersection.retainAll(bSet);

            prefix[i] = intersection.size();
            aSet.add(A[i]);
            bSet.add(B[i]);
        }

        return prefix;
    }
}
