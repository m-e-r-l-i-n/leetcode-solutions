class Solution {
    public int minScoreTriangulation(int[] v) {
        int n=v.length,dp[][]=new int[n][n],i,j,k;
        for(i=2;i<n;i++)
        for(j=0;j+i<n;j++)
        {
            dp[j][j+i]=Integer.MAX_VALUE;
            for(k=j+1;k<=j+i;k++)
            dp[j][j+i]=Math.min(dp[j][j+i],dp[j][k]+dp[k][j+i]+v[j]*v[k]*v[j+i]);
        }
        return dp[0][n-1];
    }
}
