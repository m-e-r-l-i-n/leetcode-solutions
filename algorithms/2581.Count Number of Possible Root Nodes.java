class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n=edges.length+1,i;
        ArrayList<Integer> g[]=new ArrayList[n];
        HashMap<Integer,Integer> hm[]=new HashMap[n];
        for(i=0;i<n;i++) 
        {
            g[i]=new ArrayList<>();
            hm[i]=new HashMap<>();
        }
        
        for(int e[]:edges)  //form the tree
        {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        for(int gu[]:guesses)
        hm[gu[0]].put(gu[1],hm[gu[0]].getOrDefault(gu[1],0)+1); //how many [u,v] guesses
        
        int c[]=new int[n];
        dfs(g,hm,c,0,-1);
        reroot(g,hm,c,0,-1);
        
        int ans=0;
        for(i=0;i<n;i++)
        if(c[i]>=k) ans++;
        return ans;
    }
    
    void dfs(ArrayList<Integer> g[],HashMap<Integer,Integer> hm[],int c[],int n,int p)
    {
        for(int x:g[n])
        if(x!=p)
        {
            dfs(g,hm,c,x,n);
            c[n]+=c[x];
            c[n]+=hm[n].getOrDefault(x,0);
        }
    }
    
    void reroot(ArrayList<Integer> g[],HashMap<Integer,Integer> hm[],int c[],int n,int p)
    {
        for(int x:g[n])
        if(x!=p)
        {
            c[x]+=c[n]-c[x]-hm[n].getOrDefault(x,0)+hm[x].getOrDefault(n,0);
            reroot(g,hm,c,x,n);
        }
    }
}
