class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<Integer> g[]=new ArrayList[n];
        int i,mat[][]=new int[n][n];
        for(i=0;i<n;i++)
        g[i]=new ArrayList<>();
        
        for(i=0;i<roads.length;i++)
        {
            g[roads[i][0]].add(roads[i][1]);
            g[roads[i][1]].add(roads[i][0]);
            mat[roads[i][0]][roads[i][1]]=1;
        }
        
        
        int ans=0,j;
        for(i=0;i<n;i++)
        for(j=i+1;j<n;j++)
        ans=Math.max(ans,g[i].size()+g[j].size()-Math.max(mat[i][j],mat[j][i]));
        return ans;
    }
}
