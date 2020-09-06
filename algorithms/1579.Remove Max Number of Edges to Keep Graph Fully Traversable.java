class Solution 
{
    public int maxNumEdgesToRemove(int n, int[][] edges) 
    {
        ArrayList<Integer> g[]=new ArrayList[n],al[]=new ArrayList[n],bo[]=new ArrayList[n];
        int i,c=0;
        
        for(i=0;i<n;i++)
        {
            g[i]=new ArrayList<>();
            al[i]=new ArrayList<>();
            bo[i]=new ArrayList<>();
        }
        
        for(i=0;i<edges.length;i++)
        {
            int u=edges[i][1]-1,v=edges[i][2]-1;
            if(edges[i][0]==3)
            {
                g[u].add(v);
                g[v].add(u);
            }
            else if(edges[i][0]==1)
            {
                al[u].add(v);
                al[v].add(u);
            }
            else 
            {
                bo[u].add(v);
                bo[v].add(u);
            }
        }
        
        boolean vis[]=new boolean[n],vis2[]=new boolean[n];
        for(i=0;i<n;i++)
        if(!vis[i] && g[i].size()!=0)
        c+=bfs(g,i,vis,0);
        
        if(count(vis)==n)   //all nodes visited 
            return edges.length-(n-1);    
        
        for(i=0;i<n;i++)
        vis2[i]=vis[i];
        
        bfs(al,-1,vis,1);
        bfs(bo,-1,vis2,1);
        if(count(vis)!=n || count(vis2)!=n) return -1;
        //the number of edges needed=2*(no of edges in 1 tree-no of common edges)+no of common edges
        c=2*(n-1-c)+c;  
        
        return edges.length-c;
    }
    
    int bfs(ArrayList<Integer> g[],int n,boolean vis[],int t)
    {
        Queue<Integer> q=new LinkedList<>();
        int sz=0;   //count number of edges
        
        if(t==1)
        {
            for(int i=0;i<vis.length;i++)
            if(vis[i]) q.add(i); 
            if(q.isEmpty()) //for cases when there are no edges og type 3 
            {
                q.add(0); 
                vis[0]=true;
            }
        }
        else 
        {
            vis[n]=true;
            q.add(n);
        }
        
        while(!q.isEmpty())
        {
            int p=q.poll();
            for(int x:g[p])
            if(!vis[x])
            {
                vis[x]=true;
                q.add(x);
                sz++;
            }
        }
        return sz;        
    }
    
    int count(boolean vis[])
    {
        int i,c=0,n=vis.length;
        for(i=0;i<n;i++)
        if(vis[i]) c++;
        return c;
    }
}
