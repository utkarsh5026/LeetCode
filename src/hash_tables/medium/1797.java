package hash_tables.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// https://leetcode.com/problems/design-authentication-manager/description/
// 1797. Design Authentication Manager
class AuthenticationManager {
    private int timeToLive;
    private Map<String, Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (tokens.containsKey(tokenId) && tokens.get(tokenId) > currentTime) {
            tokens.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        Iterator<Map.Entry<String, Integer>> iterator = tokens.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() > currentTime) {
                count++;
            } else {
                iterator.remove(); // Remove expired tokens
            }
        }
        return count;
    }
}
