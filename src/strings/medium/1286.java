package strings.medium;

import java.util.*;

// https://leetcode.com/problems/iterator-for-combination/description/
// 1286. Iterator for Combination
class CombinationIterator {

    int currIdx;
    List<String> combinations;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<>();
        currIdx = 0;
        generateCombinations(0, characters.toCharArray(), combinationLength, new StringBuilder());
        Collections.sort(combinations);
    }

    public String next() {
        return combinations.get(currIdx++);
    }

    public boolean hasNext() {
        return currIdx < combinations.size();
    }

    void generateCombinations(int start, char[] chars, int limit, StringBuilder psf) {
        if (psf.length() == limit) {
            combinations.add(psf.toString());
            return;
        }

        for (int i = start; i < chars.length; i++) {
            char ch = chars[i];
            psf.append(ch);
            generateCombinations(i + 1, chars, limit, psf);
            psf.deleteCharAt(psf.length() - 1);
        }
    }
}