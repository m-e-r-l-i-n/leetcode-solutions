class Solution {
    public int rearrangeSticks(int n, int k) {
        long dp[][]=new long[n+1][n+1],M=1000000007;
        int i,j; dp[0][0]=1;
        for(i=1;i<=n;i++)
        {
            int v=i-1;
            for(j=0;j<i;j++)
            dp[i][j]=(dp[i-1][j]*v%M+M)%M;
            for(j=0;j<i;j++)
            dp[i][j+1]=(dp[i][j+1]+dp[i-1][j])%M;    
        }
        return (int)dp[n][k];
    }
}
