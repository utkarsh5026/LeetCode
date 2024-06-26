package queues.medium;

import java.util.LinkedList;

// https://leetcode.com/problems/design-front-middle-back-queue/description/
// 1670. Design Front Middle Back Queue
class FrontMiddleBackQueue {

    LinkedList<Integer> ll;

    public FrontMiddleBackQueue() {
        ll = new LinkedList<>();
    }

    public void pushFront(int val) {
        ll.addFirst(val);
    }

    public void pushMiddle(int val) {
        int mid = ll.size() / 2;
        ll.add(mid, val);
    }

    public void pushBack(int val) {
        ll.addLast(val);
    }

    public int popFront() {
        if (!ll.isEmpty())
            return ll.removeFirst();
        return -1;
    }

    public int popMiddle() {
        if (ll.isEmpty())
            return -1;

        int middle = ll.size() % 2 == 0 ? (ll.size() / 2) - 1 : ll.size() / 2;

        return ll.remove(middle);
    }

    public int popBack() {
        if (!ll.isEmpty())
            return ll.pollLast();
        return -1;
    }
}
