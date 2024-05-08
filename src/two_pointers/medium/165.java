package two_pointers.medium;

// https://leetcode.com/problems/compare-version-numbers/description/
// 165. Compare Version Numbers
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        int ip1 = 0;
        int ip2 = 0;

        while (ip1 < parts1.length || ip2 < parts2.length) {
            String v1 = ip1 >= parts1.length ? "0" : parts1[ip1];
            String v2 = ip2 >= parts2.length ? "0" : parts2[ip2];

            int comparison = compare(v1, v2);
            if (comparison != 0)
                return comparison;

            ip1++;
            ip2++;
        }
        return 0;
    }

    private int compare(String partA, String partB) {
        int p1 = removeTrailingZeroes(partA);
        int p2 = removeTrailingZeroes(partB);

        if (p1 > p2)
            return 1;
        else if (p1 < p2)
            return -1;
        else
            return 0;
    }

    private int removeTrailingZeroes(String a) {
        int i = 0;
        while (i < a.length()) {
            if (a.charAt(i) != '0')
                break;
            i++;
        }
        return i == a.length() ? 0 : Integer.parseInt(a.substring(i));
    }
}