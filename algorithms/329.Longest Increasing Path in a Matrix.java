class Solution {
    public int longestIncreasingPath(int[][] a)
    {
        n=a.length; m=a[0].length;
        int dp[][]=new int[n][m],i,j;
        for(i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        int ans=0;
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        {
            if(dp[i][j]==-1) dfs(a,dp,i,j);
            ans=Math.max(ans,dp[i][j]);
        }
        return ans;
    }
    
    int dir[][]={{-1,0},{0,1},{0,-1},{1,0}},n,m;
    int dfs(int a[][],int dp[][],int i,int j)
    {
        if(dp[i][j]!=-1) return dp[i][j];
        for(int d[]:dir)
        {
            int tx=i+d[0],ty=j+d[1];
            if(tx<0 || ty<0 || tx>=n || ty>=m) continue;
            if(a[tx][ty]>a[i][j]) dp[i][j]=Math.max(dp[i][j],1+dfs(a,dp,tx,ty));
        }
        dp[i][j]=Math.max(dp[i][j],1);
        return dp[i][j];
    }
}
