class Solution {
    public int[] findBall(int[][] g) {
        int i,j,k,n=g.length,m=g[0].length,ans[]=new int[m];
        for(i=0;i<m;i++)
        {
            Queue<Point> q=new LinkedList<>();
            q.add(new Point(0,i));
            int col=-1;
            while(!q.isEmpty())
            {
                Point p=q.poll();
                if(p.x==n) {col=p.y; break;}
                if(g[p.x][p.y]==1)
                {
                    if(p.y==m-1 || g[p.x][p.y+1]==-1) break;
                    else q.add(new Point(p.x+1,p.y+1));
                }
                else
                {
                    if(p.y==0 || g[p.x][p.y-1]==1) break;
                    else q.add(new Point(p.x+1,p.y-1));
                }
            }
            ans[i]=col;
        }    
        return ans;
    }
    
    class Point
    {
        int x,y;
        Point(int a,int b)
        {
            x=a;
            y=b;
        }
    }
}
