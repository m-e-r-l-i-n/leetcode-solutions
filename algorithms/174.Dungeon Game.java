class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length,n=dungeon[0].length,i,j,dp[][]=new int[m+1][n+1];
        for(i=0;i<=m;i++)
        Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[m][n-1]=dp[m-1][n]=1;
        for(i=m-1;i>=0;i--)
        for(j=n-1;j>=0;j--)
        {
            int add=Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j];
            dp[i][j]=add<=0?1:add;
        }
        return dp[0][0];
    }
}
