class Solution {
    public int minSkips(int[] dist, int speed, int h) 
    {
        int n=dist.length,l=0,r=n,m;
        while(l<r)
        {
            m=(l+r)>>1;
            if(time(dist,m,speed)<=1l*speed*h) r=m;
            else l=m+1;
        }
        return l<n?l:-1;
    }
    
    int time(int a[],int k,int s)
    {
        int dp[]=new int[k+1],n=a.length,i,j;
        for(i=0;i<n;i++)
        for(j=k;j>=0;j--)
        {
            dp[j]+=a[i];
            if(i<n-1) dp[j]=(dp[j]+s-1)/s*s;
            if(j>0) dp[j]=Math.min(dp[j],dp[j-1]+a[i]);
        }    
        return dp[k];
    }
}
