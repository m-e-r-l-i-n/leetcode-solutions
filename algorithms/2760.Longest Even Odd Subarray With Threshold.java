class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int i=0,n=nums.length,max=0;
        while(i<n)
        {
            if(nums[i]>threshold || nums[i]%2==1) {i++; continue;}
            
            int j=i+1;
            while(j<n && nums[j]<=threshold && nums[j]%2!=nums[j-1]%2) j++;
            
            max=Math.max(max,j-i);
            i=j;
        }
        return max;
    }
}
