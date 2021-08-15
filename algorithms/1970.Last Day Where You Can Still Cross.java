class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        g=new boolean[row][col]; vis=new int[row][col];
        for(int i=0;i<row;i++) Arrays.fill(vis[i],-1);
        
        int l=0,r=cells.length,ans=0,m;
        while(l<=r)
        {
            m=(l+r)>>1;
            if(possible(cells,m))
            {
                ans=m;
                l=m+1;
            }
            else r=m-1;
        }
        return ans;
    }
    
    boolean g[][]; int vis[][];
    boolean possible(int a[][],int max)
    {
        int i,n=g.length,m=g[0].length;
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<max;i++)
        g[a[i][0]-1][a[i][1]-1]=true;
        
        for(i=0;i<m;i++)
        if(!g[0][i]) {q.add(0); q.add(i); vis[0][i]=max;}
        
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            int px=q.poll(),py=q.poll();
            for(int d[]:dir)
            {
                int tx=px+d[0],ty=py+d[1];
                if(tx>=0 && tx<n && ty>=0 && ty<m && !g[tx][ty] && vis[tx][ty]!=max)
                {
                    vis[tx][ty]=max;
                    q.add(tx); q.add(ty);
                }
            }
        }
        
        for(i=0;i<max;i++) g[a[i][0]-1][a[i][1]-1]=false;
        for(i=0;i<m;i++)
        if(vis[n-1][i]==max) return true;
        return false;
    }
}
