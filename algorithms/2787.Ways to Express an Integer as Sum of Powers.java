class Solution {
    public int numberOfWays(int n, int x) {
        int coin=1; //coin change problem, let us consider a^x as a coin denomination
        
        int dp[]=new int[n+1],M=(int)1e9+7;
        dp[0]=1;
        while(power(coin,x)<=n)
        {
            int i,p=power(coin,x);
            for(i=n;i-p>=0;i--)
            {
                dp[i]+=dp[i-p];
                if(dp[i]>=M) dp[i]-=M;
            }
            coin++;
        }
        return dp[n];
    }
    
    static int power(int a,int b)
    {
        int res=1;
        while(b!=0)
        {
            if(b%2==1) res=res*a;
            b>>=1;
            a=a*a;
        }
        return res;
    }
}
