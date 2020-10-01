class RecentCounter {

    Queue<Integer> q;
    public RecentCounter() {
        q=new LinkedList<>();
    }
    
    public int ping(int t) {
        while(!q.isEmpty() && t-q.peek()>3000) q.poll();
        q.add(t);
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
