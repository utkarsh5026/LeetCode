package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/sort-the-people/description/
// 2418. Sort the People
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Pair> people = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            people.add(new Pair(names[i], heights[i]));
        }

        Collections.sort(people, (a, b) -> b.height - a.height);
        String[] sortedNames = new String[names.length];
        for (int i = 0; i < people.size(); i++) {
            sortedNames[i] = people.get(i).name;
        }

        return sortedNames;
    }

    static class Pair {
        String name;
        int height;

        Pair(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

}
