class Solution {
    public void moveZeroes(int[] nums) {
        int i,z=0,n=nums.length;
        for(i=0;i<n;i++)
        {
            if(nums[i]==0) {z++; continue;}
            nums[i-z]=nums[i];
        }
        for(i=n-1;i>n-1-z;i--)
            nums[i]=0;
    }
}
