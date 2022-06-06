//Tamonash Chakraborty
//O(n) in total where n is number of calls
class RateLimiter {
    Queue<Integer> q;
    int time,max;
    public RateLimiter(int n, int t) {
        max=n;
        time=t;
        q=new LinkedList<>();
    }
    
    public boolean shouldAllow(int timestamp) {
        while(!q.isEmpty() && q.peek()<=timestamp-time) q.poll();
        if(q.size()<max) 
        {
            q.add(timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your RateLimiter object will be instantiated and called as such:
 * RateLimiter obj = new RateLimiter(n, t);
 * boolean param_1 = obj.shouldAllow(timestamp);
 */
