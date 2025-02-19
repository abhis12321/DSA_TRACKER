class Twitter {
    private int timeStamp;
    private Map<Integer,User> userMap;
    private class User {
        private int userId;
        private Tweet tweetHead;
        private Set<Integer> followList;

        private User(int userId) {
            this.userId = userId;
            followList = new HashSet<>();
            follow(userId);
        }

        private void follow(int user) {
            followList.add(user);
        }

        private void unfollow(int user) {
            if(userId != user) {
                followList.remove(user);
            }
        }

        private void post(int tweetId) {
            Tweet T = new Tweet(tweetId);
            T.next = tweetHead;
            tweetHead = T;
        }

        private Set<Integer> getFollowList() {
            return followList;
        }
    }

    private class Tweet {
        private int tweetId;
        private int tweetedAt;
        private Tweet next;
        private Tweet(int id) {
            next = null;
            tweetId = id;
            this.tweetedAt = timeStamp++;
        }
        private int getTweet() {
            return tweetId;
        }
    }
    public Twitter() {
        this.timeStamp = 0;
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) {
            userMap.put(userId , new User(userId));
        }
        userMap.get(userId).post(tweetId);        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followList = userMap.getOrDefault(userId , new User(userId)).getFollowList();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) -> b.tweetedAt - a.tweetedAt);

        for(int id : followList) {
            Tweet T = userMap.getOrDefault(id , new User(id)).tweetHead;
            if(T != null) {
                maxHeap.offer(T);
            }
        }

        int count = 10;
        List<Integer> A = new ArrayList<>();
        while(count-- > 0 && !maxHeap.isEmpty()) {
            Tweet T = maxHeap.poll();
            A.add(T.tweetId);
            if(T.next != null) {
                maxHeap.offer(T.next);
            }
        }
        return A;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            userMap.put(followerId , new User(followerId));
        }
        if(!userMap.containsKey(followeeId)) {
            userMap.put(followeeId , new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            userMap.put(followerId , new User(followerId));
        }
        if(!userMap.containsKey(followeeId)) {
            userMap.put(followeeId , new User(followeeId));
        }
        userMap.get(followerId).unfollow(followeeId);
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */