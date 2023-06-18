class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int i,ans=Integer.MAX_VALUE;
        for(i=1;i<nums.length;i++) ans=Math.min(ans,nums[i]-nums[i-1]);
        return ans;
    }
}
