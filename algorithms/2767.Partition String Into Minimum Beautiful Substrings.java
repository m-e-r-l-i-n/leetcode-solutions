class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int i,j,n=s.length(),dp[]=new int[n+1],M=(int)1e9;
        Arrays.fill(dp,M);
        dp[0]=0;
        for(i=1;i<=n;i++)
        for(j=i;j>0;j--)
        if(power(s,j-1,i-1)) dp[i]=Math.min(dp[i],dp[j-1]+1);    
        
        if(dp[n]==M) dp[n]=-1;
        return dp[n];
    }
    
    boolean power(String s,int l,int r)
    {
        if(s.charAt(l)=='0') return false;
        
        int x=0,p2=1;
        for(int i=r;i>=l;i--)
        {
            if(s.charAt(i)=='1') x+=p2;
            p2*=2;
        }
        
        while(x%5==0) x/=5;
        return x==1;
    }
}
