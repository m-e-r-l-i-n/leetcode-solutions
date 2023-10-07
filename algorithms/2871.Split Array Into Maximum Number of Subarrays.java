class Solution {
    public int maxSubarrays(int[] nums) {
        int n=nums.length,dp[]=new int[n+1],c[]=new int[23],i,j,l=0;
        Arrays.fill(dp,-2*n);
        dp[0]=0;
        for(i=0;i<n;i++) 
        {
            for(j=0;j<23;j++) c[j]+=(nums[i]>>j)&1;
            
            while(currentAndIsZero(c,l,i))
            {
                for(j=0;j<23;j++) c[j]-=(nums[l]>>j)&1;
                dp[i+1]=Math.max(dp[i+1],dp[l]+1);
                l++;
            }
            //System.out.println(l+" "+i);
        }
        int ans=1;
        for(i=1;i<=n;i++) ans=Math.max(ans,dp[i]);
        return ans;
    }
    
    boolean currentAndIsZero(int c[],int l,int r)
    {
        for(int x:c)
        if(x==r-l+1) return false;
        return true;
    }
}

/*
[1,0,2,0,1,2]
[5,7,1,3]
[0,0,0,0,0]
[1,2,3]
[1,0,0,1,0]
*/
