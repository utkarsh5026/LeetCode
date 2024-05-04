package arrays.medium;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/description/
// 881. Boats to Save People
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int start = 0;
        int end = people.length - 1;

        while (start < end) {
            int lighter = people[start];
            int heavier = people[end];

            // takinng both of them
            if (lighter + heavier <= limit)
                start++;

            // taking only single person
            end--;
            boats++;
        }
        return boats;
    }
}