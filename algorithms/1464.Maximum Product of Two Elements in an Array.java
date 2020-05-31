class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0]>nums[1]?nums[0]:nums[1],max2=nums[0]+nums[1]-max,i;
        for(i=2;i<nums.length;i++)
        if(nums[i]>max)
        {max2=max; max=nums[i];}
        else if(nums[i]>max2) max2=nums[i];
        return (max2-1)*(max-1);
    }
}
