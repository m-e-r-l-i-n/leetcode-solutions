class Solution {
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>(){
            public int compare(long o1[],long o2[])
            {
                if(o1[1]>o2[1]) return 1;
                else return -1;
            }});
        
        int i; long dp[]=new long[n],M=(int)1e9+7,path[]=new long[n],mx=(long)1e18;
        ArrayList<int[]> g[]=new ArrayList[n];
        for(i=0;i<n;i++) 
        {
            g[i]=new ArrayList<>();
            dp[i]=mx;
        }
        
        for(int r[]:roads)
        {
            g[r[0]].add(new int[]{r[1],r[2]});
            g[r[1]].add(new int[]{r[0],r[2]});
        }
        
        pq.add(new long[]{0,0}); dp[0]=0; path[0]=1;
        while(!pq.isEmpty())
        {
            long p[]=pq.poll();
            i=(int)p[0];
            
            for(int x[]:g[i])
            {
                long v=p[1]+x[1];
                if(dp[x[0]]>v) 
                {
                    dp[x[0]]=v;
                    pq.add(new long[]{x[0],v});
                    path[x[0]]=path[i];
                }
                else if(dp[x[0]]==v) path[x[0]]=(path[x[0]]+path[i])%M;
            }
        }
        return (int)path[n-1];
    }
}
