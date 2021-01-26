class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length,m=heights[0].length,i;
        int dp[][]=new int[n][m],d[]={0,1,0,-1,0};
        for(i=0;i<n;i++)
        Arrays.fill(dp[i],Integer.MAX_VALUE);
        
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty())
        {
            int p[]=pq.poll(),r=p[1],c=p[2];
            if(p[0]>dp[r][c]) continue;
            if(r==n-1 && c==m-1) return p[0];
            
            for(i=0;i<4;i++) 
            {
                int nr=r+d[i],nc=c+d[i+1];
                if(nr>=0 && nr<n && nc>=0 && nc<m) 
                {
                    int di=Math.max(p[0],Math.abs(heights[nr][nc]-heights[r][c]));
                    if(dp[nr][nc]>di) 
                    {
                        dp[nr][nc]=di;
                        pq.add(new int[]{dp[nr][nc],nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}
