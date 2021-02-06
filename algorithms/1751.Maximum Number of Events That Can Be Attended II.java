class Solution {
    public int maxValue(int[][] e, int k) {
        Arrays.sort(e,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[1]>o2[1]) return 1;
                else if(o1[1]==o2[1]) return o1[0]>=o2[0]?1:-1;
                else return -1;
            }});
        int n=e.length,dp[][]=new int[n+1][k+1],i,j,max[][]=new int[n+1][k+1],ans=0;
        
        for(i=1;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
            Arrays.fill(max[i],-1);
        }
        
        for(i=1;i<=n;i++)
        {
            int last=getmax(e,e[i-1][0]);
            dp[i][1]=e[i-1][2];
            max[i][1]=Math.max(max[i-1][1],dp[i][1]);
            ans=Math.max(ans,max[i][1]);
            for(j=2;j<=k;j++)
            {
                if(last==-1) dp[i][j]=-1;
                else if(max[last][j-1]==-1) dp[i][j]=-1;
                else dp[i][j]=max[last][j-1]+e[i-1][2];
                max[i][j]=Math.max(max[i-1][j],dp[i][j]);    
                ans=Math.max(ans,max[i][j]);
            }
        }
        return ans;
    }
    
    static int getmax(int e[][],int k)
    {
        if(k<=e[0][1]) return -1;
        int l=0,r=e.length-1,mid,ans=0;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(e[mid][1]<k)
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans+1;
    }
}
