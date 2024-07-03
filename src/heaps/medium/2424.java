package heaps.medium;

// https://leetcode.com/problems/longest-uploaded-prefix/description/
// 2424. Longest Uploaded Prefix
class LUPrefix {
    boolean[] uploaded;
    int lastUploaded;

    public LUPrefix(int n) {
        uploaded = new boolean[n + 1];
        lastUploaded = 0;
    }

    public void upload(int video) {
        uploaded[video] = true;

    }

    public int longest() {
        int length = 0;
        for (int i = lastUploaded + 1; i < uploaded.length; i++) {
            if (uploaded[i])
                length++;
            else
                break;
        }

        lastUploaded += length;
        return lastUploaded;
    }
}