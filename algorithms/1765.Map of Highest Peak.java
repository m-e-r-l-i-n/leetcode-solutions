class Solution {
    public int[][] highestPeak(int[][] w) {
        int n=w.length,m=w[0].length,a[][]=new int[n][m],i,j;
        boolean vis[][]=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        {
            a[i][j]=-1;
            if(w[i][j]==1)
            {
                a[i][j]=0;
                q.add(new Pair(i,j));
                vis[i][j]=true;
            }
        }
        
        int d[][]={{-1,0},{0,-1},{1,0},{0,1}};
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int max=Integer.MAX_VALUE;
            for(int x[]:d)
            {
                int tx=p.x+x[0],ty=p.y+x[1];
                if(tx>=0 && tx<n && ty>=0 && ty<m)
                {
                    if(!vis[tx][ty])
                    {
                        vis[tx][ty]=true;
                        q.add(new Pair(tx,ty));
                    }
                    else if(a[tx][ty]>-1) max=Math.min(max,a[tx][ty]); 
                }
            }
            if(a[p.x][p.y]==-1) a[p.x][p.y]=max+1;
        }
        return a;
    }
    
    class Pair
    {
        int x,y;
        Pair(int a,int b)
        {
            x=a;
            y=b;
        }
    }
}
