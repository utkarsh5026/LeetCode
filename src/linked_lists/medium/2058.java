package linked_lists.medium;

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

// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/
// 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = { -1, -1 }; // Initialize with -1 as per problem requirement

        if (head == null || head.next == null || head.next.next == null)
            return result;

        ListNode prev = head;
        ListNode curr = head.next;
        int firstCP = -1;
        int lastCP = -1;
        int minDist = Integer.MAX_VALUE;
        int index = 1;

        while (curr.next != null) {
            if (isCriticalPoint(prev.val, curr.val, curr.next.val)) {
                if (firstCP == -1) {
                    firstCP = index;
                } else {
                    minDist = Math.min(minDist, index - lastCP);
                }
                lastCP = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }

        if (lastCP - firstCP > 0) {
            result[0] = minDist;
            result[1] = lastCP - firstCP;
        }

        return result;
    }

    private boolean isCriticalPoint(int prev, int curr, int next) {
        return (curr > prev && curr > next) || (curr < prev && curr < next);
    }
}