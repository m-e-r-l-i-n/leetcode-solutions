class Solution {
    public int minimumXORSum(int[] a, int[] b) 
    {
        int i,j,n=a.length,m=1<<n;
        int dp[][]=new int[n][m];
        for(i=0;i<n;i++)
        {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[0][1<<i]=a[0]^b[i];
        }
        for(i=1;i<n;i++)
        for(j=0;j<m;j++)
        if(dp[i-1][j]!=Integer.MAX_VALUE)
        for(int k=0;k<n;k++)
        if(((j>>k)&1)!=1) dp[i][j|(1<<k)]=Math.min(dp[i][j|(1<<k)],dp[i-1][j]+(a[i]^b[k]));
        
        int ans=Integer.MAX_VALUE;
        for(i=0;i<m;i++)
        ans=Math.min(ans,dp[n-1][i]);
        return ans;
    }
}
