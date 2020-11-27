class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums) sum+=x;
        if(sum%2==1) return false;
        sum/=2;
        int i,j,n=nums.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(i=0;i<=n;i++)
        dp[i][0]=true; 
        
        for(i=1;i<=n;i++)
        for(j=nums[i-1];j<=sum;j++)
        dp[i][j]=dp[i-1][j] | dp[i-1][j-nums[i-1]];  
        return dp[n][sum];
    }
}
