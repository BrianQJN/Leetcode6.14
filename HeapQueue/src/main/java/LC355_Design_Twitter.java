import java.util.*;

/**
 * @author Brian Qu
 * @version 1.0
 * @implSpec
 * @since 2024-07-01
 */
public class LC355_Design_Twitter {
    // timestamps for all tweets
    private int timestamp = 0;

    // HashMap to store user's followees
    private Map<Integer, Set<Integer>> followees;

    // HashMap to store user's tweets
    private Map<Integer, List<Tweet>> tweets;

    private class Tweet {
        int id;
        int time;

        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
        }
    }

    public LC355_Design_Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }

    /** compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // compose a new tweet
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(new Tweet(tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        // retrieve the 10 most recent tweets ids in the user's news feed
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // add user's own tweets
        if (tweets.containsKey(userId)) {
            maxHeap.addAll(tweets.get(userId));
        }

        // add tweets from followees
        Set<Integer> userFollowees = followees.getOrDefault(userId, new HashSet<>());
        for (int userFollowee : userFollowees) {
            if (tweets.containsKey(userFollowee)) {
                maxHeap.addAll(tweets.get(userFollowee));
            }
        }

        // compose the news feed
        List<Integer> feed = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            feed.add(maxHeap.poll().id);
            count++;
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        // follower follows a followee
        if (followerId != followeeId) {
            followees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        // unfollow a followee
        if (followees.containsKey(followerId)) {
            followees.get(followerId).remove(followeeId);
        }
    }
}
