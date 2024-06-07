package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/description/
// 1418. Display Table of Food Orders in a Restaurant
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> tableMap = new HashMap<>();
        Set<String> dishes = new HashSet<>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            tableMap.computeIfAbsent(table, items -> new HashMap<>());

            Map<String, Integer> items = tableMap.get(table);
            items.computeIfAbsent(foodItem, cnt -> 0);
            items.put(foodItem, items.get(foodItem) + 1);
            dishes.add(foodItem);
        }
        List<String> sortedDishes = new ArrayList<>(dishes);
        Collections.sort(sortedDishes);
        List<List<String>> result = new ArrayList<>();

        List<String> headers = new ArrayList<>();
        headers.add("Table");
        headers.addAll(sortedDishes);

        List<List<String>> tableOrders = createTable(tableMap, sortedDishes);

        result.add(headers);
        result.addAll(tableOrders);
        return result;
    }

    List<List<String>> createTable(Map<Integer, Map<String, Integer>> table, List<String> dishes) {

        List<Integer> sortedTable = new ArrayList<>(table.keySet());
        Collections.sort(sortedTable);

        List<List<String>> tableOrders = new ArrayList<>();
        for (int tableNo : sortedTable) {
            Map<String, Integer> order = table.get(tableNo);
            List<String> display = new ArrayList<>();

            display.add(String.valueOf(tableNo));
            for (String dish : dishes) {
                int orderCnt = order.getOrDefault(dish, 0);
                display.add(String.valueOf(orderCnt));
            }

            tableOrders.add(display);
        }

        return tableOrders;
    }

}
