package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
// 1376. Time Needed to Inform All Employees
class Solution {

    class Employee {
        int id;
        int time;

        public Employee(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager.length == 1)
            return 0;
        Map<Integer, List<Employee>> relation = makeGraph(manager, informTime);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        return getTotalInformTime(headID, relation, visited);
    }

    private Map<Integer, List<Employee>> makeGraph(int[] manager, int[] informTime) {
        Map<Integer, List<Employee>> managerEmployeeRelation = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int reportsTo = manager[i];

            if (reportsTo < 0)
                continue;
            managerEmployeeRelation.computeIfAbsent(reportsTo, k -> new ArrayList<>());
            managerEmployeeRelation.get(reportsTo).add(new Employee(i, informTime[reportsTo]));
        }
        return managerEmployeeRelation;
    }

    private int getTotalInformTime(int manager, Map<Integer, List<Employee>> relation, boolean[] visited) {
        visited[manager] = true;

        if (!relation.containsKey(manager))
            return 0;

        List<Employee> employees = relation.get(manager);
        int maxTime = 0;
        for (Employee e : employees) {
            if (visited[e.id])
                continue;
            int timeToInform = getTotalInformTime(e.id, relation, visited) + e.time;
            maxTime = Math.max(maxTime, timeToInform);
        }

        return maxTime;
    }
}
