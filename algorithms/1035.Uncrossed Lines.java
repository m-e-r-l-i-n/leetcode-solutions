class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int n=A.length,m=B.length,dp[][]=new int[n+1][m+1],i,j;
        for(i=0;i<=n;i++)
        for(j=0;j<=m;j++)
        if(i==0||j==0) dp[i][j]=0;
        else if(A[i-1]==B[j-1]) dp[i][j]=1+dp[i-1][j-1];
        else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);  //longest common subsequence
        return dp[n][m];
    }
}
