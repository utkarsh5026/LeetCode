package arrays.medium;

import java.util.*;

// https://leetcode.com/problems/3sum/description/
// 15. 3Sum
class Solution {
    class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Set<String> tripletSet = new HashSet<>();

        Arrays.sort(nums);
        if (nums.length < 3)
            return triplets;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicates
            int curr = nums[i];
            List<Pair> pairs = twoSum(nums, -curr, i + 1);
            addTriplets(triplets, tripletSet, pairs, curr);
        }
        return triplets;
    }

    private List<Pair> twoSum(int[] nums, int target, int start) {
        int end = nums.length - 1;
        List<Pair> pairs = new ArrayList<>();

        while (start < end) {
            int fromStart = nums[start];
            int fromEnd = nums[end];
            int sum = fromEnd + fromStart;

            if (sum == target) {
                pairs.add(new Pair(fromStart, fromEnd));
                while (start < end && nums[start] == nums[start + 1])
                    start++;
                while (start < end && nums[end] == nums[end - 1])
                    end--;
                start++;
                end--;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return pairs;
    }

    private void addTriplets(List<List<Integer>> triplets, Set<String> tripletsFound, List<Pair> pairs, int x) {
        for (Pair p : pairs) {
            List<Integer> triplet = Arrays.asList(x, p.a, p.b);
            Collections.sort(triplet);
            String tripletString = triplet.toString();
            if (!tripletsFound.contains(tripletString)) {
                triplets.add(triplet);
                tripletsFound.add(tripletString);
            }
        }
    }
}
