package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/distant-barcodes/description/
// 1054. Distant Barcodes
class Solution {
    class Barcode {
        int code;
        int frequency;

        public Barcode(int code, int frequency) {
            this.code = code;
            this.frequency = frequency;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int bar : barcodes) {
            frequency.put(bar, frequency.getOrDefault(bar, 0) + 1);
        }

        PriorityQueue<Barcode> maxHeap = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            maxHeap.add(new Barcode(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[barcodes.length];
        int index = 0;

        while (!maxHeap.isEmpty()) {
            Barcode first = maxHeap.poll();
            if (index == 0 || result[index - 1] != first.code) {
                result[index] = first.code;
                index++;
                first.frequency--;
                if (first.frequency > 0) {
                    maxHeap.offer(first);
                }
            } else {
                if (maxHeap.isEmpty()) {
                    return new int[0]; // Impossible to rearrange
                }
                Barcode second = maxHeap.poll();
                result[index] = second.code;
                index++;
                second.frequency--;
                if (second.frequency > 0) {
                    maxHeap.offer(second);
                }
                maxHeap.offer(first);
            }
        }

        return result;
    }
}