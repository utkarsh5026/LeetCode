package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/description/
// 2477. Minimum Fuel Cost to Report to the Capital
class Solution {

    private static final int CAPITAL_CITY = 0;
    private long fuel = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> connections = new HashMap<>();
        for (int[] road : roads) {
            connections.putIfAbsent(road[0], new ArrayList<>());
            connections.putIfAbsent(road[1], new ArrayList<>());
            connections.get(road[0]).add(road[1]);
            connections.get(road[1]).add(road[0]);
        }

        dfs(CAPITAL_CITY, connections, seats, new HashSet<>());
        return fuel;
    }

    private int dfs(int node, Map<Integer, List<Integer>> connections, int seats, Set<Integer> visited) {
        visited.add(node);
        int people = 1; // Count the current node itself

        for (int neighbor : connections.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                people += dfs(neighbor, connections, seats, visited);
            }
        }

        if (node != CAPITAL_CITY) {
            fuel += (people + seats - 1) / seats; // Calculate the number of cars needed for 'people'
        }

        return people;
    }
}
