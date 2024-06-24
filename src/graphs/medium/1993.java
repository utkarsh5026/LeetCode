package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/operations-on-tree/description/
// 1993. Operations on Trees
class LockingTree {
    int[] parent;
    boolean[] locked;
    int[] lockedBy;
    Map<Integer, Set<Integer>> children;

    public LockingTree(int[] parent) {
        int n = parent.length;
        this.parent = parent;
        this.locked = new boolean[n];
        this.lockedBy = new int[n];
        Arrays.fill(lockedBy, -1);
        this.children = new HashMap<>();

        for (int i = 0; i < n; i++) {
            children.put(i, new HashSet<>());
        }

        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (locked[num]) {
            return false;
        }
        locked[num] = true;
        lockedBy[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (!locked[num] || lockedBy[num] != user) {
            return false;
        }
        locked[num] = false;
        lockedBy[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (locked[num]) {
            return false;
        }
        if (!hasLockedDescendant(num)) {
            return false;
        }
        if (hasLockedAncestor(num)) {
            return false;
        }

        // Unlock all descendants
        unlockDescendants(num);

        // Lock the current node
        locked[num] = true;
        lockedBy[num] = user;
        return true;
    }

    private boolean hasLockedDescendant(int num) {
        for (int child : children.get(num)) {
            if (locked[child] || hasLockedDescendant(child)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLockedAncestor(int num) {
        int curr = parent[num];
        while (curr != -1) {
            if (locked[curr]) {
                return true;
            }
            curr = parent[curr];
        }
        return false;
    }

    private void unlockDescendants(int num) {
        for (int child : children.get(num)) {
            if (locked[child]) {
                locked[child] = false;
                lockedBy[child] = -1;
            }
            unlockDescendants(child);
        }
    }
}
