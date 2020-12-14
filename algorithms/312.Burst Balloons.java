class Solution {
    public int maxCoins(int[] nums) 
    {
        int n=nums.length,a[]=new int[n+2],i=1;
        
        for(int x : nums) 
        if(x>0) a[i++]=x;
        a[0]=a[i++]=1;
        n=i;
    
        int dp[][]=new int[n][n];
        for(i=2;i<n;i++)
        for(int l=0;l<n-i;l++) 
        {
            int r=l+i,j;
            for(j=l+1;j<r;j++)
            dp[l][r]=Math.max(dp[l][r],a[l]*a[j]*a[r]+dp[l][j]+dp[j][r]);
        }
        return dp[0][n-1];
    }
}
