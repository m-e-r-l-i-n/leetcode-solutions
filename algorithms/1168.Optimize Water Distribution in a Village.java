class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> edges=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[2]>o2[2]) return 1;
                else return -1;
            }});
        
        //Kruskal's MST
        int par[]=new int[n+1],i;
        for(i=0;i<=n;i++) 
        {
            par[i]=i;
            if(i<n) edges.add(new int[]{i,n,wells[i]});    //edge from well to house
        }
        for(int x[]:pipes) edges.add(new int[]{x[0]-1,x[1]-1,x[2]});    //edges between wells
        
        int ans=0;
        while(!edges.isEmpty())
        {
            int edge[]=edges.poll();
            edge[0]=parent(par,edge[0]);
            edge[1]=parent(par,edge[1]);
            if(edge[0]==edge[1]) continue;
            ans+=edge[2];
            par[edge[0]]=edge[1];
        }
        return ans;
    }
    
    int parent(int p[],int i)   //parent in DSU
    {
        if(p[i]==i) return i;
        return p[i]=parent(p,p[i]);
    }
}
