class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length(),dp[][]=new int[2][m+1];
        int i,j,cur=1;
        for(i=n-1;i>=0;i--,cur^=1)
        for(j=m-1;j>=0;j--)
        {
            dp[cur][j]=Math.max(dp[cur^1][j],dp[cur][j+1]);
            if(word1.charAt(i)==word2.charAt(j)) dp[cur][j]=Math.max(dp[cur][j],dp[cur^1][j+1]+1);
        }
        return n+m-2*dp[cur^1][0];
    }
}

