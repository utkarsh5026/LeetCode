package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/points-that-intersect-with-cars/description/
// 2848. Points That Intersect With Cars
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> coveredPoints = new HashSet<>();

        // Iterate through each car's start and end points
        for (List<Integer> car : nums) {
            int start = car.get(0);
            int end = car.get(1);

            for (int point = start; point <= end; point++) {
                coveredPoints.add(point);
            }
        }

        return coveredPoints.size();
    }
}