class Solution {
    public int minRefuelStops(int t, int s, int[][] a) 
    {
        int cur=s,ans=0,i,n=a.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(i=0;i<n;i++)
        {
            while(!pq.isEmpty() && cur<a[i][0])
            {
                ans++;
                cur+=pq.poll();
            }
            if(cur<a[i][0]) return -1;
            pq.add(a[i][1]);
        }    
        while(!pq.isEmpty() && cur<t)
        {
            ans++;
            cur+=pq.poll();
        }
        if(cur<t) return -1;
        return ans;
    }
}
