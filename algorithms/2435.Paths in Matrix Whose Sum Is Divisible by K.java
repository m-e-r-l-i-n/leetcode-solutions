class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        int dp[][][]=new int[2][m][k],M=(int)1e9+7,i,cur=1;

        dp[0][0][0]=1;
        for(i=0;i<n;i++)
        {
            int j,l,x,md;
            for(j=0;j<m;j++)
            {
                x=grid[i][j];
                for(l=0;l<k;l++)
                {
                    md=(x+l)%k;
                    dp[cur][j][md]=dp[cur^1][j][l];
                    if(j>0) dp[cur][j][md]+=dp[cur][j-1][l];
                    if(dp[cur][j][md]>=M) dp[cur][j][md]-=M;
                }
            }
            cur^=1;
        }
        return dp[cur^1][m-1][0];        
    }
}
