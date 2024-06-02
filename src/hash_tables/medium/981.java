package hash_tables.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/time-based-key-value-store/description/
// 981. Time Based Key-Value Store
class TimeMap {
    private HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> pairs = map.get(key);
        return binarySearch(pairs, timestamp);
    }

    private String binarySearch(List<Pair> pairs, int timestamp) {
        int left = 0;
        int right = pairs.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair p = pairs.get(mid);
            if (p.timestamp <= timestamp) {
                result = p.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
