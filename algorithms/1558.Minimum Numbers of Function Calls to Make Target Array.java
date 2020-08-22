class Solution {
    public int minOperations(int[] nums) {
        int ans=0,n=nums.length,i;
        while(true)
        {
            int z=0;
            for(i=0;i<n;i++)
            if(nums[i]%2==1) break;
            else if(nums[i]==0) z++;
            if(z==n) break;
            
            if(i==n)    //all even
            {
                ans++;
                for(int j=0;j<n;j++)
                nums[j]/=2;    
            }
            for(int j=i;j<n;j++)
            if(nums[j]%2==1)
            {
                nums[j]--;
                ans++;
            }
        }
        return ans;
    }
}
