package graphs.medium;

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

// https://leetcode.com/problems/employee-importance/description/
// 690. Employee Importances
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> graph = makeEmployeeGraph(employees);
        return dfs(id, graph, new HashSet<>());
    }

    Map<Integer, Employee> makeEmployeeGraph(List<Employee> employees) {
        Map<Integer, Employee> graph = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            graph.put(e.id, e);
        }

        return graph;
    }

    int dfs(int id, Map<Integer, Employee> graph, Set<Integer> visited) {
        int importance = graph.get(id).importance;
        List<Integer> subordinates = graph.get(id).subordinates;

        for (int subId : subordinates) {
            if (visited.contains(subId))
                continue;

            importance += dfs(subId, graph, visited);
        }

        return importance;
    }

}