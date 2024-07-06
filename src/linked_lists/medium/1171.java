package linked_lists.medium;

import java.util.*;

import jdk.nashorn.internal.runtime.regexp.joni.ast.Node;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/
// 1171. Remove Zero Sum Consecutive Nodes from Linked List
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }

        boolean[] remove = new boolean[nodes.size()];
        Arrays.fill(remove, false);
        Map<Integer, Integer> sumIdx = new HashMap<>();
        sumIdx.put(0, -1);
        int currSum = 0;
        for (int i = 0; i < nodes.size(); i++) {
            currSum += nodes.get(i);
            if (sumIdx.containsKey(currSum)) {
                int idx = sumIdx.get(currSum) + 1;

                if (!remove[idx]) {
                    for (int j = idx; j <= i; j++) {
                        remove[j] = true;
                    }
                }
            }

            sumIdx.put(currSum, i);
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for (int i = 0; i < nodes.size(); i++) {
            if (remove[i])
                continue;

            curr.next = new ListNode(nodes.get(i));
            curr = curr.next;
        }

        return dummy.next;
    }
}