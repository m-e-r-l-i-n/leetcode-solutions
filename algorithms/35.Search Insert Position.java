class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=0;
        while(l<=r)   //int p=Arrays.binarySearch(nums,target);
        {
            mid=(l+r)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) r=mid-1;
            else l=mid+1;
        }
        //if(p<0) p=-p-1;
        return l; //return p;
    }
}
