package greedy.easy;

// https://leetcode.com/problems/lemonade-change/description/
// 860. Lemonade Change
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fives++;
                    break;
                case 10:
                    if (fives == 0)
                        return false;
                    fives--;
                    tens++;
                    break;
                case 20:
                    if (tens > 0 && fives > 0) {
                        tens--;
                        fives--;
                    } else if (fives >= 3)
                        fives -= 3;
                    else
                        return false;
                    break;
                default:
                    return false;
            }
        }

        return true;
    }
}