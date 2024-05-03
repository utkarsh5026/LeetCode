package stacks.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/asteroid-collision/description/
// 735. Asteroid Collision
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> remainingAsterioids = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];

            if (remainingAsterioids.isEmpty()) {
                remainingAsterioids.add(asteroid);
                continue;
            }
            int prevAsteroid = remainingAsterioids.peekLast();
            remainingAsterioids.add(asteroid);

            if (!asteroidsWillCollide(prevAsteroid, asteroid))
                destoryAsteroids(remainingAsterioids);
        }

        return fromDequeToArray(remainingAsterioids);
    }

    private int[] fromDequeToArray(Deque<Integer> nums) {
        int[] arr = new int[nums.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums.pollFirst();
        }
        return arr;
    }

    private void destoryAsteroids(Deque<Integer> asteroids) {

        while (asteroids.size() > 1) {
            System.out.println(asteroids);
            int last = asteroids.pollLast();
            int secondLast = asteroids.pollLast();

            if (asteroidsWillCollide(secondLast, last)) {
                asteroids.add(secondLast);
                asteroids.add(last);
                break;
            }
            if (Math.abs(last) > Math.abs(secondLast))
                asteroids.add(last);
            else if (Math.abs(secondLast) > Math.abs(last))
                asteroids.add(secondLast);
        }
    }

    private boolean asteroidsWillCollide(int before, int after) {
        return before > 0 && after < 0;
    }
}
