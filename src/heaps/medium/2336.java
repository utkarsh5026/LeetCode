package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/smallest-number-in-infinite-set/description/
// 2336. Smallest Number in Infinite Set
class SmallestInfiniteSet {

    private PriorityQueue<Integer> elements;
    private Set<Integer> elementsSet;
    int curr;

    public SmallestInfiniteSet() {
        this.curr = 1;
        this.elements = new PriorityQueue<>();
        this.elementsSet = new HashSet<>();
        this.elements.add(curr);
        this.elementsSet.add(curr);
    }

    public int popSmallest() {
        int smallest = elements.poll();
        curr++;
        elements.add(curr);

        if (elementsSet.contains(smallest))
            elementsSet.remove(smallest);
        return smallest;
    }

    public void addBack(int num) {
        if (elementsSet.contains(num) || num == curr)
            return;
        elementsSet.add(num);
        elements.add(num);
    }
}
