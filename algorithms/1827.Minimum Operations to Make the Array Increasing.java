class Solution {
    public int minOperations(int[] nums) {
        int ans=0;
        for(int i=1;i<nums.length;i++)        
        {
            int t=Math.max(0,nums[i-1]-nums[i]+1);
            nums[i]+=t;
            ans+=t;
        }
        return ans;
    }
}
