class KthLargest {
    PriorityQueue<Integer> max,min;
    int k;
    public KthLargest(int k, int[] nums) {
        max=new PriorityQueue<>();
        min=new PriorityQueue<>(Collections.reverseOrder());
        this.k=k;
        for(int x:nums) max.add(x);
        while(max.size()>k) min.add(max.poll());
    }
    
    public int add(int val) {
        max.add(val);
        while(!max.isEmpty() && !min.isEmpty() && max.peek()<min.peek())
        {
            int u=max.poll(),v=min.poll();
            max.add(v); min.add(u);
        }
        while(max.size()>k) min.add(max.poll());
        return max.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
