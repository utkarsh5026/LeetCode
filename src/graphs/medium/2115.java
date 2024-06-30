package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/
// 2115. Find All Possible Recipes from Given Supplies
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String recipie = recipes[i];
            for (String ingred : ingredients.get(i)) {
                graph.putIfAbsent(ingred, new ArrayList<>());
                graph.get(ingred).add(recipie);
            }
        }

        return toposort(graph, Arrays.asList(supplies), new HashSet<>(Arrays.asList(recipes)));
    }

    List<String> toposort(Map<String, List<String>> graph, List<String> supplies, Set<String> recipies) {
        Map<String, Integer> indegree = new HashMap<>();

        for (Map.Entry<String, List<String>> ingred : graph.entrySet()) {
            for (String recipe : ingred.getValue()) {
                indegree.put(recipe, indegree.getOrDefault(recipe, 0) + 1);
            }
        }

        Deque<String> queue = new ArrayDeque<>(supplies);

        List<String> successfulReciepes = new ArrayList<>();
        while (!queue.isEmpty()) {
            String recipie = queue.pollFirst();
            if (recipies.contains(recipie))
                successfulReciepes.add(recipie);

            List<String> usedIn = graph.getOrDefault(recipie, new ArrayList<>());
            for (String rec : usedIn) {
                indegree.put(rec, indegree.get(rec) - 1);
                if (indegree.get(rec) == 0)
                    queue.add(rec);
            }
        }

        return successfulReciepes;
    }

}
