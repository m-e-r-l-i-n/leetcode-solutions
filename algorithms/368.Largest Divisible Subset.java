class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int i,j,n=nums.length,dp[]=new int[n],pre[]=new int[n],max=0,maxi=-1;
        Arrays.sort(nums);
        for(i=0;i<n;i++)
        {
            pre[i]=-1; dp[i]=1;
            for(j=i-1;j>=0;j--)
            if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]) 
            {
                dp[i]=dp[j]+1;
                pre[i]=j;
            }
            if (dp[i]>max) 
            {
                max=dp[i];
                maxi=i;
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(maxi!=-1)
        {
            ans.add(nums[maxi]);
            maxi=pre[maxi];
        }
        return ans;
    }
}
