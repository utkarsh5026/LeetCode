package hash_tables.hard;

import java.util.*;

// https://leetcode.com/problems/all-oone-data-structure/description/
// 432. All O`one Data Structure
class AllOne {

    Map<String, Integer> count;
    Map<Integer, Set<String>> countBack;
    String maxKey;
    String minKey;

    public AllOne() {
        count = new HashMap<>();
        countBack = new HashMap<>();
        this.maxKey = "";
        this.minKey = "";
    }

    public void inc(String key) {
        count.put(key, count.getOrDefault(key, 0) + 1);
        int cnt = count.get(key);
        countBack.putIfAbsent(cnt, new HashSet<>());
        countBack.get(cnt).add(key);

        if (countBack.containsKey(cnt - 1)) {
            countBack.get(cnt - 1).remove(key);
        }
        setMinMax();
    }

    public void dec(String key) {
        count.put(key, count.get(key) - 1);
        int cnt = count.get(key);

        if (countBack.containsKey(cnt + 1))
            countBack.get(cnt + 1).remove(key);

        if (cnt == 0) {
            count.remove(key);
        } else {
            countBack.putIfAbsent(cnt, new HashSet<>());
            countBack.get(cnt).add(key);
        }
        setMinMax();
    }

    public String getMaxKey() {
        return maxKey;
    }

    public String getMinKey() {
        return minKey;
    }

    private void setMinMax() {

        maxKey = countBack.get(Collections.max(countBack.keySet())).iterator().next();
        minKey = countBack.get(Collections.min(countBack.keySet())).iterator().next();
    }
}
