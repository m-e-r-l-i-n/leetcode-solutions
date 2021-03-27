class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] g) {
        if(g.length==0 || g[0].length==0)
        {
            List<List<Integer>> l=new ArrayList<>();
            return l;
        }
        int n=g.length,m=g[0].length,c[][]=new int[n][m];
        boolean v[][]=new boolean[n][m];
        Queue<Cell> q=new LinkedList<>();
        int i,j;
        for(i=0;i<n;i++)
        {
            if(i==0)
            for(j=1;j<m;j++) 
            {
                q.add(new Cell(i,j));
                v[i][j]=true;
                c[i][j]++;
            }
            q.add(new Cell(i,0));
            v[i][0]=true;
            c[i][0]++;
        }    
        bfs(q,v,c,g);
        
        q=new LinkedList<>();
        for(i=0;i<n;i++)
        {
            Arrays.fill(v[i],false);
            if(i==n-1)
            for(j=0;j<m-1;j++)
            {
                q.add(new Cell(i,j));
                v[i][j]=true;
                c[i][j]++;
            }
            q.add(new Cell(i,m-1));
            v[i][m-1]=true;
            c[i][m-1]++;
        }
        bfs(q,v,c,g);
        
        List<List<Integer>> ans=new ArrayList<>();
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(c[i][j]==2)
        {
            List<Integer> t=new ArrayList<>();
            t.add(i); t.add(j);
            ans.add(t);
        }
        return ans;
    }
    
    void bfs(Queue<Cell> q,boolean v[][],int c[][],int g[][])
    {
        int n=v.length,m=v[0].length,d[][]={{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            Cell p=q.poll();
            for(int di[]:d)
            {
                int tx=p.x+di[0],ty=p.y+di[1];
                if(tx>=0 && tx<n && ty>=0 && ty<m && !v[tx][ty] && g[tx][ty]>=g[p.x][p.y])
                {
                    v[tx][ty]=true;
                    c[tx][ty]++;
                    q.add(new Cell(tx,ty));
                }
            }
        }
    }
    
    class Cell
    {
        int x,y;
        Cell(int a,int b)
        {
            x=a;
            y=b;
        }
    }
}
