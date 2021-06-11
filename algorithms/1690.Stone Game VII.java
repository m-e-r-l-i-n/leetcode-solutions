class Solution {
    public int stoneGameVII(int[] a) {
        int i,n=a.length;
        sum=new int[n+1]; dp=new int[n][n];
        for(i=1;i<=n;i++)
        {
            sum[i]=sum[i-1]+a[i-1];
            Arrays.fill(dp[i-1],-1);
        }
        return solve(0,n-1);
    }
    
    int sum[],dp[][];
    int solve(int l,int r)
    {
        if(r<l) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        dp[l][r]=Math.max(sum[r+1]-sum[l+1]-solve(l+1,r),sum[r]-sum[l]-solve(l,r-1));
        return dp[l][r];
    }
}
