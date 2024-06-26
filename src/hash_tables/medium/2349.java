package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/design-a-number-container-system/description/
// 2349. Design a Number Container System
class NumberContainers {

    Map<Integer, Integer> idxMap;
    Map<Integer, TreeSet<Integer>> indices;

    public NumberContainers() {
        this.idxMap = new HashMap<>();
        this.indices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (idxMap.containsKey(index)) {
            int owner = idxMap.get(index);
            indices.get(owner).remove(index);

            if (indices.get(owner).isEmpty())
                indices.remove(owner);
        }
        indices.putIfAbsent(number, new TreeSet<>());
        idxMap.put(index, number);
        indices.get(number).add(index);
    }

    public int find(int number) {
        if (!indices.containsKey(number))
            return -1;
        return indices.get(number).first();
    }
}
