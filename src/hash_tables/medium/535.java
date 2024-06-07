package hash_tables.medium;

import java.util.*;

// https://leetcode.com/problems/encode-and-decode-tinyurl/description/
// 535. Encode and Decode TinyURL
class Codec {

    public static final String TINY_URL = "https://tinyurl.com/";
    public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int SMALL_URL_LENGTH = 6;

    Map<String, String> longToTiny;
    Map<String, String> tinyToLong;

    public Codec() {
        longToTiny = new HashMap<>();
        tinyToLong = new HashMap<>();
    }

    private String generateTinyUrl() {
        StringBuilder tiny = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < SMALL_URL_LENGTH; i++) {
            char ch = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
            tiny.append(ch);
        }
        return tiny.toString();
    }

    public String encode(String longUrl) {
        if (longToTiny.containsKey(longUrl))
            return longToTiny.get(longUrl);

        String tiny = generateTinyUrl();
        while (tinyToLong.containsKey(tiny)) {
            tiny = generateTinyUrl();
        }

        longToTiny.put(longUrl, tiny);
        tinyToLong.put(tiny, longUrl);
        return longToTiny.get(longUrl);
    }

    public String decode(String shortUrl) {
        if (!tinyToLong.containsKey(shortUrl))
            return "";
        return tinyToLong.get(shortUrl);
    }
}