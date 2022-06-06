//Tamonash Chakraborty
//O(1) for writePost
//O(1) for addFriend
//O(n) for showPosts where n is number of posts
class Facebook {

    ArrayList<String> post;
    ArrayList<Integer> user;
    HashMap<Integer,HashSet<Integer>> friends;
    public Facebook() {
        post=new ArrayList<>();
        user=new ArrayList<>();
        friends=new HashMap<>();
    }
    
    public void writePost(int userId, String postContent) {
        post.add(postContent);  //what the post is
        user.add(userId);   //who posts it
    }
    
    public void addFriend(int user1, int user2) {
        if(friends.get(user1)==null) friends.put(user1,new HashSet<>());
        if(friends.get(user2)==null) friends.put(user2,new HashSet<>());
        friends.get(user1).add(user2);   //make them friends
        friends.get(user2).add(user1);
    }
    
    public List<String> showPosts(int userId) {
        int s=post.size(),i;
        List<String> ans=new ArrayList<>();
        for(i=s-1;i>=0;i--) //which posts to be considered among all posts
        if(friends.containsKey(userId) && friends.get(userId).contains(user.get(i)))
        ans.add(post.get(i));
        return ans;
    }
}

/**
 * Your Facebook object will be instantiated and called as such:
 * Facebook obj = new Facebook();
 * obj.writePost(userId,postContent);
 * obj.addFriend(user1,user2);
 * List<String> param_3 = obj.showPosts(userId);
 */
