package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/destination-city/description/
// 1436. Destination City
class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> outgoingCities = new HashSet<>();

        // Add all cities that have outgoing paths to the set
        for (List<String> path : paths) {
            outgoingCities.add(path.get(0));
        }

        for (List<String> path : paths) {
            String destinationCity = path.get(1);
            if (!outgoingCities.contains(destinationCity)) {
                return destinationCity;
            }
        }

        return "";
    }
}