package arrays.medium;

import java.util.*;

// https://leetcode.com/problems/design-memory-allocator/description/
// 2502. Design Memory Allocator
class Allocator {

    class Block {
        int start;
        int end;

        public Block(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    Map<Integer, List<Block>> allocation;
    int[] memory;

    public Allocator(int n) {
        this.allocation = new HashMap<>();
        this.memory = new int[n];
        Arrays.fill(memory, -1);
    }

    public int allocate(int size, int mID) {
        allocation.putIfAbsent(mID, new ArrayList<>());
        int idx = 0;
        while (idx < memory.length) {
            int block = memory[idx];
            if (block == -1) {
                int cnt = 0;
                int start = idx;
                while (idx < memory.length && memory[idx] == -1 && cnt < size) {
                    cnt++;
                    idx++;
                }

                if (cnt == size) {
                    System.out.println(cnt + " " + idx);
                    allocation.get(mID).add(new Block(start, start + size - 1));
                    for (int i = start; i < start + size; i++) {
                        memory[i] = mID;
                    }
                    return start;
                }
            } else
                idx++;
        }

        return -1;
    }

    public int free(int mID) {
        if (!allocation.containsKey(mID))
            return 0;
        List<Block> memoryBlocks = allocation.get(mID);
        int freed = 0;
        for (Block b : memoryBlocks) {
            for (int i = b.start; i <= b.end; i++) {
                memory[i] = -1;
            }
            freed += b.end - b.start + 1;
        }

        allocation.remove(mID);
        return freed;
    }
}
