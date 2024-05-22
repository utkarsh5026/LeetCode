package strings.medium;

import java.util.*;

// https://leetcode.com/problems/search-suggestions-system/description/
// 1268. Search Suggestions System
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (char ch : searchWord.toCharArray()) {
            prefix.append(ch);
            List<String> matches = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(prefix.toString())) {
                    matches.add(product);
                }
                if (matches.size() == 3) {
                    break;
                }
            }
            result.add(matches);
        }
        return result;
    }
}
