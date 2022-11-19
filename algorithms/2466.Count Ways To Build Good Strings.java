class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[]=new int[high+1],M=(int)1e9+7,i,ans=0;
        dp[0]=1;
        for(i=1;i<=high;i++)
        {
            if(i-zero>=0) dp[i]=(dp[i]+dp[i-zero])%M;
            if(i-one>=0) dp[i]=(dp[i]+dp[i-one])%M;
            
            if(i>=low) ans=(ans+dp[i])%M;
        }
        return ans;
    }
}
