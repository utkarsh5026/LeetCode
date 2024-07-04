package heaps.medium;

import java.util.*;

// https://leetcode.com/problems/most-popular-video-creator/description/
// 2456. Most Popular Video Creator
class Solution {

    class Video {
        String id;
        int viewCount;

        public Video(String id, int viewCount) {
            this.id = id;
            this.viewCount = viewCount;
        }
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

        Map<String, List<Video>> creatorVideos = new HashMap<>();
        Map<String, Long> popularity = new HashMap<>();

        long highestPopularity = Long.MIN_VALUE;
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            creatorVideos.putIfAbsent(creator, new ArrayList<>());
            creatorVideos.get(creator).add(new Video(ids[i], views[i]));
            popularity.put(creator, popularity.getOrDefault(creator, 0L) + views[i]);
            highestPopularity = Math.max(highestPopularity, popularity.get(creator));
        }

        List<String> mostPopular = new ArrayList<>();
        for (Map.Entry<String, Long> creator : popularity.entrySet()) {
            if (creator.getValue() == highestPopularity)
                mostPopular.add(creator.getKey());
        }

        return getBestVideos(mostPopular, creatorVideos);
    }

    private List<List<String>> getBestVideos(List<String> mostPopular, Map<String, List<Video>> creatorVideos) {
        List<List<String>> bestVideos = new ArrayList<>();

        for (String creator : mostPopular) {
            List<Video> videos = creatorVideos.get(creator);
            Video best = Collections.max(videos, (a, b) -> {
                if (a.viewCount == b.viewCount)
                    return b.id.compareTo(a.id);
                return a.viewCount - b.viewCount;
            });

            bestVideos.add(new ArrayList<>(Arrays.asList(creator, best.id)));
        }
        return bestVideos;
    }

}