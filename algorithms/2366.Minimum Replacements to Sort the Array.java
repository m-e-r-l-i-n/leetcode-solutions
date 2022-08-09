class Solution {
    public long minimumReplacement(int[] nums) {
        long ans=0;
        int i,n=nums.length;
        for(i=n-2;i>=0;i--)
        if(nums[i]>nums[i+1])
        {
            int times=nums[i]/nums[i+1];
            if(nums[i]%nums[i+1]==0) times--;
            ans+=times;
            
            times++;    //total number of partitions formed
            nums[i]/=times;
        }
        return ans;
    }
}   
