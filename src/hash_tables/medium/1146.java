package hash_tables.medium;

import java.util.*;

//https://leetcode.com/problems/snapshot-array/description/
// 1146. Snapshot Array
class SnapshotArray {
    private List<Map<Integer, Integer>> history;
    private int snapId;

    public SnapshotArray(int length) {
        history = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            history.add(new HashMap<>());
            history.get(i).put(0, 0);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        history.get(index).put(snapId, val);
    }

    public int snap() {
        snapId++;
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        while (!history.get(index).containsKey(snap_id)) {
            snap_id--;
        }
        return history.get(index).get(snap_id);
    }
}
