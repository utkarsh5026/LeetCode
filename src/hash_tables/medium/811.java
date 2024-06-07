package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/subdomain-visit-count/description/
// 811. Subdomain Visit Count
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> cnt = new HashMap<>();

        for (String domain : cpdomains) {
            String[] parts = domain.split("\\s+");
            int visited = Integer.parseInt(parts[0]);

            StringBuilder subdomains = new StringBuilder();
            String[] domains = parts[1].split("\\.");
            for (int i = domains.length - 1; i >= 0; i--) {
                String subdomain = domains[i];
                subdomains.insert(0, subdomain);
                cnt.put(subdomains.toString(), cnt.getOrDefault(subdomains.toString(), 0) + visited);
                subdomains.insert(0, ".");
            }
        }

        return countSubdomainVisits(cnt);
    }

    List<String> countSubdomainVisits(Map<String, Integer> cnt) {
        List<String> visits = new ArrayList<>();

        for (Map.Entry<String, Integer> visited : cnt.entrySet()) {
            String domain = visited.getKey();
            int count = visited.getValue();
            visits.add(count + " " + domain);
        }

        return visits;
    }
}