package heaps.medium;

import java.util.*;


// https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
// 786. K-th Smallest Prime Fraction
class Solution {

    class Fraction {
        int numerator;
        int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int lastIdx = arr.length - 1;
        PriorityQueue<Fraction> fractions = new PriorityQueue<>((a, b) -> {
            return compareFractions(a, b, arr);
        });

        for (int i = 0; i < arr.length; i++) {
            fractions.add(new Fraction(i, lastIdx));
        }

        while (k > 1) {
            Fraction fraction = fractions.poll();
            int num = fraction.numerator;
            int deno = fraction.denominator;
            fractions.add(new Fraction(num, deno - 1));
            k--;
        }

        Fraction kthFraction = fractions.poll();
        return new int[] { arr[kthFraction.numerator], arr[kthFraction.denominator] };
    }

    private int compareFractions(Fraction a, Fraction b, int[] arr) {
        // eg . a = 2 / 3 and b = 1 / 2;
        // Now a(2) * b(2) > b(1) * a(3)
        // that's why a > b
        int ab = arr[a.numerator] * arr[b.denominator];
        int ba = arr[a.denominator] * arr[b.numerator];
        return Integer.compare(ab, ba);
    }
}