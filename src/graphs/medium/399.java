package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/evaluate-division/description/
// 399. Evaluate Division

class Solution {

    class Pair {
        String divisor;
        double value;

        public Pair(String divisor, double value) {
            this.divisor = divisor;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> visited = new HashSet<>();
        double[] result = new double[queries.size()];
        Map<String, List<Pair>> graph = makeGraph(equations, values);

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            double value = dfs(from, to, graph, visited);

            result[i] = value;
            visited.clear();
        }
        return result;
    }

    private Map<String, List<Pair>> makeGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];

            String dividend = equation.get(0);
            String divisor = equation.get(1);

            graph.computeIfAbsent(divisor, k -> new ArrayList<>());
            graph.computeIfAbsent(dividend, k -> new ArrayList<>());

            graph.get(dividend).add(new Pair(divisor, value));
            graph.get(divisor).add(new Pair(dividend, 1 / value));

        }
        return graph;
    }

    private double dfs(String from, String to, Map<String, List<Pair>> graph, Set<String> visited) {

        boolean isInValidInput = !graph.containsKey(to) || !graph.containsKey(from);
        if (isInValidInput)
            return -1d;

        if (to.equals(from))
            return 1d;

        visited.add(from);
        List<Pair> divisors = graph.get(from);

        for (Pair p : divisors) {
            if (p.divisor.equals(to))
                return p.value;
            if (visited.contains(p.divisor))
                continue;
            double result = dfs(p.divisor, to, graph, visited);
            if (result >= 0)
                return p.value * result;
        }
        return -1d;
    }

}