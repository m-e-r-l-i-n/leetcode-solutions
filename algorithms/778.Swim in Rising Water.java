class Solution {
    public int swimInWater(int[][] grid) {
        int t=0,n=grid.length;
        int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        boolean vis[][]=new boolean[n][n];
        vis[0][0]=true;
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair o1,Pair o2)
            {
                if(o1.d>o2.d) return 1;
                else return -1;
            }});
        
        int ans=-1;
        pq.add(new Pair(0,0,grid[0][0]));
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            ans=Math.max(ans,p.d);
            if(p.x==n-1 && p.y==n-1) return ans;
            for(int d[]:dir)
            {
                int tx=p.x+d[0],ty=p.y+d[1];
                if(tx>=0 && tx<n && ty>=0 && ty<n && !vis[tx][ty])
                {
                    vis[tx][ty]=true;
                    pq.add(new Pair(tx,ty,grid[tx][ty]));
                }
            }    
        }
        return ans;
    }

    class Pair
    {
        int x,y,d;
        Pair(int a,int b,int c)
        {
            x=a;
            y=b;
            d=c;
        }
    }
}
