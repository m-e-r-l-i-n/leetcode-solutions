class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n=t.size(),i,j,dp[][]=new int[2][n],cur=1;
        dp[0][0]=t.get(0).get(0);
        for(i=1;i<t.size();i++)
        {
            dp[cur][0]=dp[cur^1][0]+t.get(i).get(0);
            for(j=1;j<i;j++)
            dp[cur][j]=Math.min(dp[cur^1][j-1],dp[cur^1][j])+t.get(i).get(j);
            dp[cur][j]=dp[cur^1][j-1]+t.get(i).get(j);
            cur^=1;
        }
        int ans=Integer.MAX_VALUE;
        for(i=0;i<n;i++) ans=Math.min(dp[cur^1][i],ans);
        return ans;
    }
}
