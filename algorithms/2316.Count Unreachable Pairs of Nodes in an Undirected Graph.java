class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<Integer> g[]=new ArrayList[n];
        int i;
        for(i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int edge[]:edges)
        {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);  
        }
        
        long reach=0;
        boolean vis[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<n;i++)
        if(!vis[i])
        {
            q.add(i);
            int c=1; vis[i]=true;
            while(!q.isEmpty())
            {
                int p=q.poll();
                for(int x:g[p])
                if(!vis[x])
                {
                    vis[x]=true;
                    q.add(x);
                    c++;
                }
            }
            reach+=1l*c*(c-1)/2;    //reachable pairs
        }
        
        return 1l*n*(n-1)/2-reach;
    }
}
