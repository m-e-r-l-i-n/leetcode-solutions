class Solution {
    public boolean possibleBipartition(int n, int[][] dis) 
    {
        Queue<Integer> q=new LinkedList<>();
        int vis[]=new int[n+1],i,j;
        Arrays.fill(vis,-1);
        for(i=1;i<=n;i++)
        if(vis[i]==-1)
        {
            vis[i]=0;
            q.add(i);
            while(!q.isEmpty())
            {
                int u=q.poll();
                for(j=0;j<dis.length;j++)
                if(dis[j][0]==u || dis[j][1]==u)
                {
                    int v=(dis[j][0]==u?dis[j][1]:dis[j][0]); 
                    if(vis[v]==-1)
                    {vis[v]=(vis[u]==0?1:0);
                    q.add(v);}
                    else if(vis[v]==vis[u]) return false;
                }
            }
        }
        return true;
    }
}
