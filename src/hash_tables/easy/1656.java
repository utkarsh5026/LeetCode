package hash_tables.easy;

import java.util.*;

// https://leetcode.com/problems/design-an-ordered-stream/description/
// 1656. Design an Ordered Stream
class OrderedStream {
    String[] stream;
    int idx;

    public OrderedStream(int n) {
        this.stream = new String[n + 1];
        Arrays.fill(stream, null);
        this.idx = 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        stream[idKey] = value;
        if (idKey > idx)
            return result;

        if (idKey == idx) {
            for (int i = idx; i < stream.length; i++) {
                if (stream[i] == null)
                    break;

                result.add(stream[i]);
            }

            while (idx < stream.length && stream[idx] != null) {
                idx++;
            }
        }

        return result;
    }
}
