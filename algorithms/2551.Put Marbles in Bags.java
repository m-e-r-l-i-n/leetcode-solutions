class Solution {
    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Integer> min=new PriorityQueue<>(),max=new PriorityQueue<>(Collections.reverseOrder());
        k--;
        int i,n=weights.length;
        for(i=0;i+1<n;i++)
        {
            int sum=weights[i]+weights[i+1];
            min.add(sum); max.add(sum);
            if(min.size()>k) min.poll();
            if(max.size()>k) max.poll();
        }
        long ans=0;
        while(!min.isEmpty()) ans+=min.poll()-max.poll();
        return ans;
    }
}
