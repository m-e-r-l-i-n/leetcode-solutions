class Solution {
    public int maxAreaOfIsland(int[][] g) 
    {
        int i,j,n=g.length,m=g[0].length,ans=0,d[][]={{0,-1},{-1,0},{1,0},{0,1}};
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(g[i][j]==1)
        {
            Queue<Integer> q=new LinkedList<>();
            q.add(i); q.add(j);
            int cur=1; g[i][j]=0;
            while(!q.isEmpty())
            {
                int x=q.poll(),y=q.poll();
                for(int di[]:d)
                {
                    int tx=x+di[0],ty=y+di[1];
                    if(tx>=0 && tx<n && ty>=0 && ty<m && g[tx][ty]==1)
                    {
                        g[tx][ty]=0;
                        cur++;
                        q.add(tx); q.add(ty);
                    }
                }
            }
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}
