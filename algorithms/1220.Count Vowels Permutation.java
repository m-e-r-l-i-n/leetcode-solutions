class Solution {
    public int countVowelPermutation(int n) {
        long dp[][]=new long[2][5],M=1000000007;
        int i,j,c=1;
        for(i=0;i<5;i++) dp[0][i]=1;
        
        for(i=1;i<n;i++)
        {
            Arrays.fill(dp[c],dp[c^1][2]);  //every vowel except 'i' can follow an 'i' 
            dp[c][0]=(dp[c][0]+dp[c^1][4]+dp[c^1][1])%M;   //a   
            dp[c][1]=(dp[c][1]+dp[c^1][0])%M;   //e
            dp[c][2]=(dp[c^1][1]+dp[c^1][3])%M; //i note that previous i is not being considered
            dp[c][4]=(dp[c][4]+dp[c^1][3])%M;   //u
            //there is no o as array is already being filled with i
            c^=1;
        }
        
        long ans=0;
        for(i=0;i<5;i++) ans=(ans+dp[c^1][i])%M;
        return (int)ans;
    }
}
