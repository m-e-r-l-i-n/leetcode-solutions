class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] e) {
        int i;
        s=new int[n]; c=new int[n];
        g=new ArrayList[n];
        for(i=0;i<n;i++) g[i]=new ArrayList<>();
        for(i=0;i<n-1;i++)
        {
            g[e[i][0]].add(e[i][1]);
            g[e[i][1]].add(e[i][0]);
        }
        
        dfs(0,-1);
        calculate(0,-1);
        return s;
    }
    
    ArrayList<Integer> g[];
    int s[],c[];
    void dfs(int n,int p)
    {
        c[n]++;
        for(int x:g[n])
        if(x!=p)
        {
            dfs(x,n);
            c[n]+=c[x];
            s[n]+=s[x]+c[x];
        }
    }
    
    void calculate(int n,int p)
    {
        int sz=g.length;
        for(int x:g[n])
        if(x!=p)
        {
            s[x]+=(s[n]-s[x]-c[x])+(sz-c[x]);
            //cost to reach till here for other nodes+cost to move the edge
            calculate(x,n);
        }
    }
}
