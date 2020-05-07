class Solution {
    public int maxSubArray(int[] nums) {
        int i,cur=nums[0],max=nums[0];
        for(i=1;i<nums.length;i++)  //Kadane's algorithm
        {
            if(cur+nums[i]>nums[i]) cur+=nums[i];
            else cur=nums[i];
            if(cur>max) max=cur;
        }
        return max;
    }
}
