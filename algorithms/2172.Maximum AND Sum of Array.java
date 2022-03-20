class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int i,m=(int)Math.pow(3,numSlots),dp[][]=new int[2][m],cur=1;
        //store 3^numSlots values
        for(int x:nums)
        {
            int j,k;
            for(j=0;j<m;j++) dp[cur][j]=dp[cur^1][j];
            
            for(j=0;j<m;j++)
            for(k=0;k<numSlots;k++)
            {
                int y=mask(j,k,numSlots);    //will add 1 to kth bit if possible, otherwise -1 
                if(y!=-1) dp[cur][y]=Math.max(dp[cur][y],dp[cur^1][j]+(x&(k+1)));
            }
            cur^=1;
        }
        
        int ans=0;
        for(i=0;i<m;i++)
        {
            int c=0,j,y=i;
            for(j=0;j<numSlots;j++)
            {
                c+=y%3;
                y/=3;
            }
            if(c==nums.length) ans=Math.max(ans,dp[cur^1][i]);
        }
        return ans;
    }
    
    int mask(int n,int b,int mx)
    {
        int i=0,p=1,ans=0;
        while(i<mx)
        {
            int d=n%3;
            n/=3;
            if(i==b && d==2) return -1; //not possible to increment
            if(i==b) d++;
            
            ans+=p*d;
            p*=3; i++;
        }
        return ans;
    }
}
