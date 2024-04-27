package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/keys-and-rooms/
// 841. Keys and Rooms
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Arrays.fill(visited, false);
        dfs(0, rooms, visited);

        for (boolean roomVisited : visited) {
            if (!roomVisited)
                return false;
        }
        return true;
    }

    public void dfs(int node, List<List<Integer>> rooms, boolean[] visited) {
        visited[node] = true;
        List<Integer> roomsToVisit = rooms.get(node);

        for (int room : roomsToVisit) {
            if (!visited[room])
                dfs(room, rooms, visited);
        }
    }
}