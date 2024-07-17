package stacks.medium;

// https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/description/
// 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] answer = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                // Assign 0 to A and 1 to B alternatively based on the current depth
                answer[i] = depth % 2;
                depth++;
            } else {
                depth--;
                // Assign 0 to A and 1 to B alternatively based on the current depth after
                // decrement
                answer[i] = depth % 2;
            }
        }

        return answer;
    }

}