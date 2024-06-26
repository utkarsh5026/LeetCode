package greedy.medium;

import java.util.*;

// https://leetcode.com/problems/design-twitter/description/
// 355. Design Twitter
class Twitter {
    private int timestamp = 0;
    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        if (following.containsKey(userId)) {
            for (int followeeId : following.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    pq.addAll(tweets.get(followeeId));
                }
            }
        }

        List<Integer> newsFeed = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            newsFeed.add(pq.poll().tweetId);
            count++;
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            following.putIfAbsent(followerId, new HashSet<>());
            following.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }

}
