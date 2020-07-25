class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,mid;
        while(l<r)
        {
            mid=l+(r-l)/2;
            if(nums[mid]>nums[r]) l=mid+1;
            else if(nums[mid]<nums[l]) {r=mid; l++;}
            else r--;
        }
        return nums[l];
    }
}
