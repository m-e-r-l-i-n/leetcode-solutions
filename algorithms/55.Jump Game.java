class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length,i,max=0;
        for(i=0;i<n;i++)
        {
            if(max<i) return false;
            if(i+nums[i]>n-1) return true;
            if(i+nums[i]>max) max=i+nums[i];
        }
        return max>=(n-1);
    }
}
