class Twitter {
    class Tweet {
        int userId;
        int tweetId;
        int seqId;
        
        public Tweet (int userId, int tweetId, int seqId) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.seqId = seqId;
        }
    }
    int seqId;
    HashMap<Integer, HashSet<Integer>> fansMap;
    HashMap<Integer, HashSet<Integer>> followeesMap;
    HashMap<Integer, List<Tweet>> userTweetMap;
    

    public Twitter() {
        seqId = 0;
        fansMap = new HashMap<>();
        followeesMap = new HashMap<>();
        userTweetMap = new HashMap<>();
    }
    
    //Time: O(1)
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId, getSeqId());
        List<Tweet> tweets = userTweetMap.getOrDefault(userId, new ArrayList<Tweet>());
        tweets.add(tweet);
        userTweetMap.put(userId, tweets);
    }
    
    //Time: O(nlogn) where n is potentially total number of tweets by user and his/her followees
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>((t1, t2) -> t1.seqId - t2.seqId);
        List<Tweet> userT = userTweetMap.getOrDefault(userId, new ArrayList<Tweet>());
        for (int i = userT.size()-1; i >= 0; i--) {
            Tweet t = userT.get(i);
            q.offer(t);
            if (q.size() > 10) {
                Tweet last = q.poll();
                if (last.seqId == t.seqId) {
                    break;
                }
            }
        }
        HashSet<Integer> followees = followeesMap.getOrDefault(userId, new HashSet<Integer>());
        for (Integer id: followees) {
            List<Tweet> followeeTweets = userTweetMap.getOrDefault(id.intValue(), new ArrayList<Tweet>());
            for (int i = followeeTweets.size() - 1; i >= 0; i--) {
                Tweet t = followeeTweets.get(i);
                q.offer(t);
                if (q.size() > 10) {
                    Tweet last = q.poll();
                    if (last.seqId == t.seqId) {
                        break;
                    }
                }
            }
        }
        Integer[] retArr = new Integer[q.size()];
        for (int index = q.size()-1; index >=0; index--) {
            retArr[index] = new Integer(q.poll().tweetId);
        }
        return Arrays.asList(retArr);
    }
    
    //Time: O(1)
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> fans = fansMap.getOrDefault(followeeId, new HashSet<Integer>());
        fans.add(followerId);
        fansMap.put(followeeId, fans);
        
        HashSet<Integer> followees = followeesMap.getOrDefault(followerId, new HashSet<Integer>());
        followees.add(followeeId);
        followeesMap.put(followerId, followees);
    }
    
    //Time: O(1)
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> fans = fansMap.get(followeeId);
        if (fans != null) {
            fans.remove(followerId);
        }
        
        HashSet<Integer> followees = followeesMap.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
    
    private int getSeqId() {
        seqId++;
        return seqId;
    }
    //alt solution could be: also construct a user class that contains a tweet linkedlist and followee list
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
