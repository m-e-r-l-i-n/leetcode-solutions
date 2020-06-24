class Solution {
    public int numTrees(int n) {
        int i,j,dp[]=new int[n+1];
        dp[0]=dp[1]=1;
        for(i=2;i<=n;i++)   //level
        for(j=1;j<=i;j++)   //root
        dp[i]+=dp[i-j]*dp[j-1];
        return dp[n];
    }
}
