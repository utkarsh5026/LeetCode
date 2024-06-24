package graphs.medium;

import java.util.*;

// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
//1233. Remove Sub-Folders from the Filesystem
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        // HashMap to store parent directories
        HashMap<String, String> parentMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String dir : folder) {
            // Find the longest valid parent directory in the map
            String parent = dir;
            while (parent.length() > 0) {
                parent = parent.substring(0, parent.lastIndexOf('/'));
                if (parentMap.containsKey(parent)) {
                    parent = parentMap.get(parent);
                    break;
                }
            }

            // If no parent is found, add to result and update the map
            if (!parentMap.containsKey(parent)) {
                result.add(dir);
                parentMap.put(dir, dir);
            }
        }

        return result;
    }
}
