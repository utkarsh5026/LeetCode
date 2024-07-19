package hash_tables.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/
// 1282. Group the People Given the Group Size They Belong To
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (!map.containsKey(size)) {
                map.put(size, new ArrayList<>());
            }
            map.get(size).add(i);
        }


        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getKey();
            List<Integer> people = entry.getValue();


            for (int i = 0; i < people.size(); i += size) {
                result.add(people.subList(i, i + size));
            }
        }

        return result;
    }
}