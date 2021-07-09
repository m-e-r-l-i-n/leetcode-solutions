class Solution {
    public int findLength(int[] n1, int[] n2) {
        int ans=0,i,j,n=n1.length,m=n2.length,dp[][]=new int[n+1][m+1];
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(n1[i]==n2[j])
        {
            dp[i+1][j+1]=dp[i][j]+1;
            ans=Math.max(ans,dp[i+1][j+1]);
        }
        return ans;
    }
}
