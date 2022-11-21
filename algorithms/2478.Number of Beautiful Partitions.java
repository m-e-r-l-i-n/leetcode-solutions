class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        boolean prime[]=new boolean[10];
        prime[2]=prime[3]=prime[5]=prime[7]=true;
        if(!prime[s.charAt(0)-'0']) return 0;
        
        int n=s.length(),dp[][]=new int[2][n],M=(int)1e9+7;
        int i,cur=1;
        for(i=1;i<n;i++)    //for the first partition only
        if(!prime[s.charAt(i)-'0'] && i+1>=minLength) dp[0][i]=1;
        
        for(i=2;i<=k;i++)
        {
            int sum=0,u,v=0;
            for(u=0;u<n;u++)
            if(!prime[s.charAt(u)-'0'])
            {
                while(u-v+1>=minLength) //all indices which can be a start are considered
                {
                    if(v-1>=0 && prime[s.charAt(v)-'0']) 
                    {
                        sum=sum+dp[cur^1][v-1];
                        if(sum>=M) sum-=M;
                    }
                    v++;
                }
                dp[cur][u]=sum;
            }
            cur^=1;
        }
        
        return dp[cur^1][n-1];
    }
}
