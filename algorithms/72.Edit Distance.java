class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length(),i,j,dp[][]=new int[m+1][n+1];
        for(i=0;i<=m;i++)   //somewhat similar approact to finding longest common subsequence
        for(j=0;j<=n;j++)
        if(i==0 || j==0) dp[i][j]=Math.max(i,j);    //base case f(0,k)=f(k,0)=k
        else if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];    //no edits needed
        else dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])); //add 1 change
        return dp[m][n];
    }
}
