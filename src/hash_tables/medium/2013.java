package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/detect-squares/description/
// 2013. Detect Squaress
class DetectSquares {

    Map<Integer, Map<Integer, Integer>> xycount;

    public DetectSquares() {
        xycount = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        xycount.putIfAbsent(x, new HashMap<>());
        xycount.get(x).put(y, xycount.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        if (!xycount.containsKey(x))
            return 0;

        Map<Integer, Integer> ycords = xycount.get(x);
        int squares = 0;
        for (Map.Entry<Integer, Integer> ycnt : ycords.entrySet()) {
            int ycord = ycnt.getKey();
            int freq = ycnt.getValue();
            if (ycord == y)
                continue;

            int dist = Math.abs(ycord - y);
            int left = x - dist;
            int right = x + dist;

            squares += freq * getPointsAt(left, y) * getPointsAt(left, ycord);
            squares += freq * getPointsAt(right, y) * getPointsAt(right, ycord);
        }

        return squares;
    }

    int getPointsAt(int targetX, int targetY) {
        Map<Integer, Integer> yCords = xycount.getOrDefault(targetX, new HashMap<>());
        return yCords.getOrDefault(targetY, 0);

    }
}
