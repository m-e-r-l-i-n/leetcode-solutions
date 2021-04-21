class Solution {
    public int combinationSum4(int[] a, int target) {
        int n=a.length,dp[]=new int[target+1],i,j;
        dp[0]=1;
        for(i=1;i<=target;i++)
        for(j=0;j<n;j++) 
        if(a[j]<=i) dp[i]+=dp[i-a[j]];
        return dp[target];
    }
}
