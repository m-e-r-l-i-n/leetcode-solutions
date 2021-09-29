class Solution {
    public long gridGame(int[][] g) {
        int i,n=g[0].length;
        long dp[][]=new long[2][n],sum[]=new long[2];
        for(i=0;i<n;i++)
        {
            dp[0][i]=g[0][i];
            if(i>0) dp[0][i]+=dp[0][i-1];
        }
        
        for(i=n-1;i>=0;i--)
        {
            dp[1][i]=g[1][i];
            if(i<n-1) dp[1][i]+=dp[1][i+1];
        }
        
        long ans=Long.MAX_VALUE;
        sum[0]=dp[0][n-1]; sum[1]=dp[1][0];
        for(i=0;i<n;i++)
        ans=Math.min(ans,Math.max(sum[0]-dp[0][i],sum[1]-dp[1][i]));
        return ans;
    }
}
