package strings.easy;

// https://leetcode.com/problems/add-binary/description/
// 67. Add Binary
class Solution {
    public String addBinary(String a, String b) {
        int ai = a.length() - 1;
        int bj = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (ai >= 0 && bj >= 0) {
            int sum = 0;
            sum += ai >= 0 ? a.charAt(ai) - '0' : 0;
            sum += bj >= 0 ? b.charAt(bj) - '0' : 0;
            sum += carry;

            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry > 0)
            result.append(carry);
        return result.reverse().toString();
    }
}
