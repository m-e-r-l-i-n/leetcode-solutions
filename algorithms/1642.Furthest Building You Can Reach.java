class Solution {
    public int furthestBuilding(int[] a, int bricks, int ladders) {
        int i,n=a.length;
        long sum=0;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(i=1;i<n;i++)
        {
            if(a[i-1]>=a[i]) continue;
            if(q.size()==ladders) break;
            q.add(a[i]-a[i-1]);
        }
        if(i==n) return i-1;
        
        for(;i<n;i++)
        if(a[i]>a[i-1])
        {
            q.add(a[i]-a[i-1]);
            int x=q.poll();
            sum+=x;
            if(sum>bricks) break;
        }
        return i-1;
    }
}
