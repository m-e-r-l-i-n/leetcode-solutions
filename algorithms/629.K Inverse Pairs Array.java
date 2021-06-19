class Solution {
    public int kInversePairs(int n, int k) {
        if(k>(n-1)*n/2) return 0;
        if(k==0 || k==n*(n-1)/2) return 1;
        int i,j;
        long dp[][]=new long[n+1][k+1],M=(int)1e9+7;
        dp[2][0]=dp[2][1]=1;
        
        for(i=3;i<=n;i++)
        {
            dp[i][0]=1;
            for(j=1;j<=Math.min(k,i*(i-1)/2);j++)
            {
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
                if(j>=i) dp[i][j]-=dp[i-1][j-i];
                dp[i][j]=(dp[i][j]+M)%M;
            }
        }
        return (int) dp[n][k];
    }
}
