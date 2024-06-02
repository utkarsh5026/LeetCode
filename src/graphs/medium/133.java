package graphs.medium;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        return clone(node, new HashMap<>());
    }

    Node clone(Node node, Map<Integer, Node> clonedMap) {
        Node cloned = new Node(node.val);
        clonedMap.put(node.val, cloned);

        for (Node nbr : node.neighbors) {
            if (clonedMap.containsKey(nbr.val))
                continue;

            clone(nbr, clonedMap);
        }

        for (Node nbr : node.neighbors) {
            Node clonedNbr = clonedMap.get(nbr.val);
            cloned.neighbors.add(clonedNbr);
        }

        return cloned;
    }
}
