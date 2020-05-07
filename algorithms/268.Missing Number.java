class Solution {
    public int missingNumber(int[] nums) {
        int ans=0,i;
        for(i=0;i<nums.length;i++)
            ans^=(i+1)^nums[i];
        return ans;
    }
}
