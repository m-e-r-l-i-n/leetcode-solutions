class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][]=new int[n+1][m+1],i;
        for(String s:strs)
        {
            int z=0,o=0,j;
            for(i=0;i<s.length();i++)
            if(s.charAt(i)=='0') z++;
            else o++;
            for(i=n;i>=o;i--)
            for(j=m;j>=z;j--)
            dp[i][j]=Math.max(dp[i][j],dp[i-o][j-z]+1);
        }
        return dp[n][m];
    }
}
