package trees.medium;

import java.util.*;

// https://leetcode.com/problems/throne-inheritance/description/
// 1600. Throne Inheritance
class ThroneInheritance {

    Map<String, List<String>> inheritence;
    Set<String> dead;
    String root;

    public ThroneInheritance(String kingName) {
        this.root = kingName;
        inheritence = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        inheritence.computeIfAbsent(parentName, c -> new ArrayList<>());
        inheritence.get(parentName).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> inheritenceOrder = new ArrayList<>();
        preorder(root, inheritenceOrder);
        return inheritenceOrder;
    }

    private void preorder(String king, List<String> inheritenceOrder) {
        if (!dead.contains(king))
            inheritenceOrder.add(king);

        if (inheritence.containsKey(king)) {
            for (String nextInLine : inheritence.get(king)) {
                preorder(nextInLine, inheritenceOrder);
            }
        }
    }
}