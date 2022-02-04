class Solution {
    public int getMoneyAmount(int n) {
        int dp[][]=new int[n+2][n+2],i,j;
        for(i=2;i<=n;i++)
        for(j=1;j+i-1<=n;j++)
        {
            int l=j,r=j+i-1,k;
            dp[l][r]=Integer.MAX_VALUE;
            for(k=l;k<=r;k++)   //optimal choice
            dp[l][r]=Math.min(dp[l][r],Math.max(dp[l][k-1],dp[k+1][r])+k);      
        }
        return dp[1][n];
    }
}
