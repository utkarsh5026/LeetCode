package stacks.easy;

// https://leetcode.com/problems/remove-outermost-parentheses/description/
// 1021. Remove Outermost Parentheses
class Solution {

    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    public String removeOuterParentheses(String s) {
        int leftCnt = 0;
        int rightCnt = 0;

        StringBuilder primitive = new StringBuilder();
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == LEFT)
                leftCnt++;
            else if (ch == RIGHT)
                rightCnt++;

            curr.append(ch);

            if (leftCnt == rightCnt) {
                primitive.append(curr.subSequence(1, curr.length() - 1).toString());
                leftCnt = 0;
                rightCnt = 0;
                curr.setLength(0);
            }
        }

        return primitive.toString();
    }
}