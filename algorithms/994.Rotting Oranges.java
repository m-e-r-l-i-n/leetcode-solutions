class Solution {
    public int orangesRotting(int[][] g) {
        int n=g.length,m=g[0].length,dep[][]=new int[n][m],i,j,c=0,mov[][]={{0,1},{1,0},{0,-1},{-1,0}};
        Queue<Point> q=new LinkedList<>();
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(g[i][j]==2) q.add(new Point(i,j,0));
        
        while(!q.isEmpty())
        {
            Point p=q.poll();
            for(int mo[]:mov)
            {
                int nx=p.x+mo[0],ny=p.y+mo[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && g[nx][ny]==1)
                {
                    dep[nx][ny]=p.d+1;
                    g[nx][ny]=2;
                    q.add(new Point(nx,ny,p.d+1));
                }
            }
        }
        
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(g[i][j]==1) return -1;
        else c=Math.max(c,dep[i][j]);
        return c;
    }
    
    class Point
    {
        int x,y,d;
        Point(int a,int b,int c)
        {
            x=a;
            y=b;
            d=c;
        }
    }
}
