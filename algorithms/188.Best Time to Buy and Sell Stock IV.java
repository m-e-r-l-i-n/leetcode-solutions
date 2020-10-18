class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length,i,j;
        if(2*k>n) 
        {
            int res=0;
            for(i=1;i<n;i++) 
            res+=Math.max(0,prices[i]-prices[i-1]);            
            return res;
        }
        
        int[][][] dp=new int[2][k+1][2];
        
        dp[0][0][0]=dp[1][0][0]=Integer.MIN_VALUE;
        for(i=0;i<=k;i++)
        dp[0][i][0]=Integer.MIN_VALUE;
        
        for(i=1;i<=n;i++) 
        {
            int cur=i&1,prev=cur^1;
            for(j=1;j<=k;j++) 
            {
                dp[cur][j][0]=Math.max(Math.max(dp[prev][j][0],dp[cur][j-1][0]),dp[prev][j-1][1]-prices[i-1]);
                dp[cur][j][1]=Math.max(Math.max(dp[prev][j][1],dp[cur][j-1][1]),dp[prev][j][0]+prices[i-1]);
            }
        }
        return dp[n&1][k][1];
    }
}
