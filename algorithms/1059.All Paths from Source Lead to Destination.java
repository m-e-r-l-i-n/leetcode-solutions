class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer> g[]=new ArrayList[n],rg[]=new ArrayList[n];
        int i;
        for(i=0;i<n;i++) 
        {
            g[i]=new ArrayList<>();
            rg[i]=new ArrayList<>();
        }
        for(int e[]:edges)
        {
            g[e[0]].add(e[1]);
            rg[e[1]].add(e[0]);
        }
        
        boolean src[]=new boolean[n],dest[]=new boolean[n];
        bfs(g,src,source); bfs(rg,dest,destination);
        
        for(i=0;i<n;i++)
        if(src[i] && !dest[i]) return false;
        
        boolean vis[]=new boolean[n],stack[]=new boolean[n];
        if(cycle(g,vis,stack,source)) return false;
        return true;
    }
    
    boolean cycle(ArrayList<Integer> g[],boolean vis[],boolean stack[],int n)
    {
        if(stack[n]==true) return true;
        stack[n]=true;
        for(int x:g[n])
        if(!vis[x])
        {
            if(cycle(g,vis,stack,x)) return true;
        }
        stack[n]=false; vis[n]=true;
        return false;
    }
    
    void bfs(ArrayList<Integer> g[],boolean vis[],int src)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        vis[src]=true;
        while(!q.isEmpty())
        {
            int p=q.poll();
            for(int x:g[p])
            if(!vis[x])
            {
                vis[x]=true;
                q.add(x);
            }
        }
    }
}
