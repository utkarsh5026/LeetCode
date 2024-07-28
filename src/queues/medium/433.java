package queues.medium;

import java.util.*;

// https://leetcode.com/problems/minimum-genetic-mutation/description
// 433. Minimum Genetic Mutation
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Pair<>(startGene, 0));
        visited.add(startGene);

        char[] genes = { 'A', 'C', 'G', 'T' };

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String gene = pair.getKey();
            int mutations = pair.getValue();

            if (gene.equals(endGene)) {
                return mutations;
            }

            char[] geneArray = gene.toCharArray();
            for (int i = 0; i < 8; i++) {
                char originalChar = geneArray[i];
                for (char c : genes) {
                    geneArray[i] = c;
                    String neighbor = new String(geneArray);
                    if (!visited.contains(neighbor) && bankSet.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(new Pair<>(neighbor, mutations + 1));
                    }
                }
                geneArray[i] = originalChar;
            }
        }

        return -1;
    }

    // Simple Pair class to hold a gene string and its mutation count
    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}