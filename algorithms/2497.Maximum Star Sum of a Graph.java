class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n=vals.length,i;
        PriorityQueue<Integer> pq[]=new PriorityQueue[n];
        for(i=0;i<n;i++) pq[i]=new PriorityQueue<>();
        for(int x[]:edges)
        {
            if(vals[x[1]]>0) pq[x[0]].add(vals[x[1]]);
            if(vals[x[0]]>0) pq[x[1]].add(vals[x[0]]);
            
            while(pq[x[0]].size()>k) pq[x[0]].poll();
            while(pq[x[1]].size()>k) pq[x[1]].poll();
        }
        
        int ans=Integer.MIN_VALUE;
        for(i=0;i<n;i++)
        {
            int cur=vals[i];
            while(!pq[i].isEmpty()) cur+=pq[i].poll();
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}
