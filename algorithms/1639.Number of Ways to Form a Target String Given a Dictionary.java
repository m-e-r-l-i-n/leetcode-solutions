class Solution {
    public int numWays(String[] words, String target) {
        int n=words.length,m=words[0].length(),l=target.length(),i,j;
        if(target.length()>m) return 0;
        
        int c[][]=new int[m][26];
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            c[j][words[i].charAt(j)-'a']++;    
        }
        
        long dp[][]=new long[m][l],M=1000000007;
        for(i=0;i<l;i++)
        for(j=i;j<m;j++)
        dp[j][i]=c[j][target.charAt(i)-'a'];
        
        for(i=1;i<m;i++)
        {
            dp[i][0]=(dp[i][0]+dp[i-1][0])%M;
            for(j=1;j<l;j++)
            dp[i][j]=((dp[i][j]*dp[i-1][j-1])%M+dp[i-1][j])%M;
        }    
        return (int)dp[m-1][l-1];
        
    } 
}
