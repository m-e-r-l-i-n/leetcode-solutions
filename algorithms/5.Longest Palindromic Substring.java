class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1) return s;
        
        boolean dp[][]=new boolean[n][n];
        int i,j;
        for(i=0;i<n;i++)
        dp[i][i]=true;
        
        int ans[]={0,1};
        for(i=2;i<=n;i++)   //length of substring
        for(j=0;j+i<=n;j++)
        {
            int e=j+i-1;
            if(i==2) dp[j][e]= s.charAt(j)==s.charAt(e);
            else dp[j][e]=dp[j+1][e-1]&(s.charAt(j)==s.charAt(e));
            if(dp[j][e]) {ans[0]=j; ans[1]=e+1;}
        }
        return s.substring(ans[0],ans[1]);
    }
}
