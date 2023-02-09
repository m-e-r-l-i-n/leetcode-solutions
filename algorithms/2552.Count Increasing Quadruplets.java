class Solution {
    public long countQuadruplets(int[] nums) {
        int n=nums.length,pre[]=new int[n+1],suf[][]=new int[n+2][n+2];
        int i,j;
        for(i=n;i>0;i--)
        for(j=0;j<=n+1;j++) 
        {
            suf[i][j]=suf[i+1][j];
            if(nums[i-1]>=j) suf[i][j]++;
        }
        
        long ans=0;
        for(i=1;i<=n;i++)
        {
            for(j=i+1;j<=n;j++)
            if(nums[i-1]>nums[j-1]) ans+=1l*pre[nums[j-1]-1]*suf[j+1][nums[i-1]+1];
            
            for(j=nums[i-1];j<=n;j++) pre[j]++;
        }
        return ans;
    }
}
