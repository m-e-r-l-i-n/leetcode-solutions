class Solution {
    public int countPalindromes(String s) {
        int n=s.length();
        long dp[][]=new long[n+1][100],M=(int)1e9+7;
        
        int i,j,dig[]=new int[10];
        for(i=1;i<=n;i++)
        {
            for(j=0;j<100;j++) dp[i][j]=dp[i-1][j];
            
            int cur=s.charAt(i-1)-'0';
            for(j=0;j<10;j++)
            {
                int v=j*10+cur; //store all possible subsequences <=i with length 2
                dp[i][v]=(dp[i][v]+dig[j])%M;
            }
            dig[cur]++;
        }
        
        long ans=0,dp2[]=new long[100];
        Arrays.fill(dig,0);
        for(i=n;i>0;i--)    //i will be the mid value
        {
            for(j=0;j<100;j++)  //fixing mid, how may pairs can be formed from left & right
            ans=(ans+dp[i-1][j]*dp2[j])%M;    
            
            int cur=s.charAt(i-1)-'0';
            for(j=0;j<10;j++)
            {
                int v=j*10+cur; //this is the reverse value
                dp2[v]=(dp2[v]+dig[j])%M;
            }
            dig[cur]++;
        }
        return (int)ans;
    }
}
