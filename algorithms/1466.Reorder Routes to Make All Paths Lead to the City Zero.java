class Solution {
    boolean vis[]; int c=0;
    public int minReorder(int n, int[][] con) {
        ArrayList<Graph> g[]=new ArrayList[n];
        int i;
        for(i=0;i<con.length;i++)
        {
            if(g[con[i][0]]==null) g[con[i][0]]=new ArrayList<>();
            if(g[con[i][1]]==null) g[con[i][1]]=new ArrayList<>();
            g[con[i][0]].add(new Graph(con[i][1],2));
            g[con[i][1]].add(new Graph(con[i][0],1));
        }
        vis=new boolean[n];
        dfs(g,0);
        return c;
    }
    void dfs(ArrayList<Graph> g[],int par)
    {
        if(vis[par]) return;
        vis[par]=true;
        for(int i=0;i<g[par].size();i++)
        if(!vis[g[par].get(i).node])
        {
            if(g[par].get(i).pos==2) c++;
            dfs(g,g[par].get(i).node);
        }
    }
    class Graph
    {
        int node,pos;
        Graph(int n,int p)
        {
            node=n;
            pos=p;
        }
    }
}
