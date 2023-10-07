class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<Integer> g[]=new ArrayList[n];
        int i,sum[]=new int[n];
        for(i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int e[]:edges)
        {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        
        return dfs(g,sum,values,k,0,-1);
    }
    
    int dfs(ArrayList<Integer> g[],int sum[],int values[],int k,int n,int p)
    {
        int tot=0;
        sum[n]=values[n]%k;
        for(int x:g[n])
        if(x!=p)  
        {
            tot+=dfs(g,sum,values,k,x,n);
            sum[n]=(sum[n]+sum[x])%k;
        }
        if(sum[n]==0) tot++;
        return tot;
    }
}
