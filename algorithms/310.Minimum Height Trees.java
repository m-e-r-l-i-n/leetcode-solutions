class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
    {
        if(n==1) return Collections.singletonList(0);
        
        Set<Integer> g[]=new HashSet[n];
        int i;
        for(i=0;i<n;i++)
        g[i]=new HashSet<>();
        
        for(int e[]:edges)
        {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        
        List<Integer> leaf=new ArrayList<>();
        for(i=0;i<n;i++)
        if(g[i].size()==1) leaf.add(i);

        while(n>2) 
        {
            n-=leaf.size();
            List<Integer> t=new ArrayList<>();
            for(int x : leaf) 
            {
                i=g[x].iterator().next();
                g[i].remove(x);
                if(g[i].size()==1) t.add(i);
            }
            leaf=t;
        }
        return leaf;
    }
}
