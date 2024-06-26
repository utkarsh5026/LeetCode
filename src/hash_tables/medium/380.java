package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1/description/
// 380. Insert Delete GetRandom O(1)
class RandomizedSet {
    Set<Integer> set;
    Map<Integer, Integer> idxMap;
    Map<Integer, Integer> numIdxMap;
    int size;
    Random random;

    public RandomizedSet() {
        this.set = new HashSet<>();
        this.idxMap = new HashMap<>();
        this.numIdxMap = new HashMap<>();
        this.random = new Random();
        this.size = 0;
    }

    public boolean insert(int val) {
        if (set.contains(val))
            return false;

        set.add(val);
        idxMap.put(size, val);
        numIdxMap.put(val, size);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val))
            return false;

        set.remove(val);
        int idx = numIdxMap.get(val);

        if (idx < size - 1) {
            int last = idxMap.get(size - 1);
            numIdxMap.put(last, idx);
            idxMap.put(idx, last);
        } else {
            numIdxMap.remove(val);
            idxMap.remove(idx);
        }
        size--;
        return true;
    }

    public int getRandom() {
        int idx = random.nextInt(set.size());
        return idxMap.get(idx);
    }
}